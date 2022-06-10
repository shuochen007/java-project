package exec.model.vo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import exec.main.GameControl;
import exec.model.load.ElementLoader;
import exec.model.vo.*;
import exec.main.GameControl;
import exec.model.load.ElementLoader;
import exec.model.manager.ElementManager;


/**
 * 地图类
 * @ClassName: Map
 * @Description: 地图类
 * @author: DaXiao
 * @CreateDate: 2019年4月11日 下午21：11
 */
public class GameMap {
    private int windowW;
    private int windowH;
    private static int mapRows;
    private static int mapCols;
    private static int biasX;
    private static int biasY;

    private static List<List<String>> mapList;//地图
    //构造函数
    public GameMap(int windowW,int windowH) {
        this.windowW = windowW;
        this.windowH = windowH;
    }

    /**
     * 判断是否超出边界
     * @param list ij列表
     * @return 是否超出边界
     */
    public boolean outOfBoundary(List<Integer> list) {
        int i = list.get(0);
        int j = list.get(1);
        if (i<0||i>=mapRows||j<0||j>=mapCols) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断是否超出边界
     * @param i
     * @param j
     * @return 是否超出边界
     */
    public boolean outOfBoundary(int i,int j) {
        if (i<0||i>=mapRows||j<0||j>=mapCols) {
            return true;
        } else {
            return false;
        }
    }

    public static List<List<String>> getMapList(){
        return mapList;
    }
    public static int getBiasX() {
        return biasX;
    }
    public static int getBiasY() {
        return biasY;
    }
    public static int getMapRows() {
        return mapRows;
    }
    public static int getMapCols() {
        return mapCols;
    }



}
