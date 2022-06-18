package exec.thread;

import java.util.List;
import java.util.Map;
import java.util.Set;

import exec.frame.OverJPanel;
import exec.main.GameStart;
import exec.model.manager.ElementManager;
import exec.model.vo.Player;
import exec.model.vo.SuperElement;

/**
 * 游戏线程控制
 * @author 麻瓜
 *
 */
public class GameThread extends Thread{
    private boolean running; //表示当前是否在进行
    private boolean over = false; //表示游戏是否结束，结束返回开始菜单
    private static int sleepTime = 20; //runGame刷新时间
    //倒计时变量
    private static int allTime = 600*1000; //10分钟


    @Override
    public void run() {
        while(!over) {
            running = true;//当前关卡正在进行
            //加载元素

            //显示人物，流程，自动化
            runGame();
            //结束当前关

        }
        GameStart.changeJPanel("over");
    }



    //显示人物，游戏流程，自动化
    private void runGame() {
        allTime = 600*1000;
        while(running) {
            Map<String, List<SuperElement>> map = ElementManager.getManager().getMap();
            Set<String> set = map.keySet();
            for(String key:set) {
                List<SuperElement> list = map.get(key);
                for(int i=list.size()-1; i>=0; i--) {
                    list.get(i).update();
                    if(!list.get(i).isAlive())
                        list.remove(i);
                }
            }

            //控制runGame进程
            allTime = allTime - sleepTime;
            try {
                sleep(20);
            } catch (InterruptedException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
    }

    //runGame调用，加入拓展
    public void linkGame() {}


    public static int getAllTime() {
        return allTime;
    }


}
