package exec.model.load;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.ImageIcon;

/**
 * 资源加载器
 * 使用单例设计模式
 * @author lc
 *
 */
public class ElementLoader {
    private static ElementLoader elementLoader;
    private Properties properties;
    private Map<String, List<String>> gameInfoMap;//游戏信息字典
    private Map<String, ImageIcon> imageMap;//图片字典

    //构造函数
    private ElementLoader() {
        properties = new Properties();
        gameInfoMap = new HashMap<>();
        imageMap = new HashMap<>();
    }

    //单例模式
    public static ElementLoader getElementLoader() {
        if (elementLoader == null) {
            elementLoader = new ElementLoader();
        }
        return elementLoader;
    }

    //读取主配置文件
    public void readGamePro() throws IOException {
        InputStream inputStream = ElementLoader.class.getClassLoader().getResourceAsStream("exec/pro/Game.pro");
        properties.clear();
        properties.load(inputStream);
        for(Object o:properties.keySet()) {
            String info = properties.getProperty(o.toString());
            gameInfoMap.put(o.toString(), infoStringToList(info,","));
        }
    }

    //读取图片
    public void readImagePro() throws IOException{
        InputStream inputStream =
                ElementLoader.class.getClassLoader().getResourceAsStream(gameInfoMap.get("imageProPath").get(0));
        properties.clear();
        properties.load(inputStream);
        for(Object o:properties.keySet()) {
            String loc = properties.getProperty(o.toString());
            imageMap.put(o.toString(), new ImageIcon(loc));
        }
    }

    /**
     * 将配置项按照指定字符串切割后转为字符串List
     * @param info 配置项字符串
     * @param splitString 切割字符串
     * @return 切割后的字符串List
     */
    private List<String> infoStringToList(String info,String splitString){
        return Arrays.asList(info.split(splitString));
    }

    public Map<String, List<String>> getGameInfoMap() {
        return gameInfoMap;
    }

    public Map<String, ImageIcon> getImageMap() {
        return imageMap;
    }


    //返回窗口w,h,windowSize[0]=w
    public List<Integer> getWindowSize(){
        List<String> data = gameInfoMap.get("windowSize");
        List<Integer> windowSize = new ArrayList<>();
        for(int i=0; i<data.size(); i++)
            windowSize.add(Integer.parseInt(data.get(i)));
        return windowSize;
    }

}
