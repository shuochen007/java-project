package exec.main;

import exec.frame.GameFrame;
import exec.frame.GameJPanel;
import exec.model.load.ElementLoader;
import exec.thread.MusicThread;

import java.io.IOException;

/**
 * @author :lc
 * @date :2022-6-6
 * @Classname :游戏开始
 * @Description :游戏的启动入口
 * The main class of the game.
 */
public class GameStart {
    private static GameFrame gameFrame;
    public static  void main(String[] args) {
        try {
            ElementLoader.getElementLoader().readGamePro();
            ElementLoader.getElementLoader().readImagePro();
        } catch (IOException e) {
            System.out.println("资源加载失败");
            e.printStackTrace();
        }
        //初始化
        gameFrame = new GameFrame();
        //界面显示
        gameFrame.setVisible(true);
        MusicThread musicPlayer= new MusicThread();
        musicPlayer.start();
    }
    /**
     * 界面切换
     * @param panelName 界面名称
     */
    public static void changeJPanel(String panelName){
        if(panelName == "game") {
            GameControl.setGameRunning(true);
            gameFrame.addListener();
        } else {
            GameControl.setGameRunning(false);
            gameFrame.removeListener();
        }
        gameFrame.changePanel(panelName);

        //强制刷新，否则监听无效
        gameFrame.setVisible(false);
        gameFrame.setVisible(true);
    }
    public static void stopMusic() throws InterruptedException {
        MusicThread.stop =1;
    }
    public static void keepMusic() throws InterruptedException{
        MusicThread.stop =0;
    }
    public static void startNewGame() {
        GameControl.setGameRunning(true);
        gameFrame.startGame();
        changeJPanel("game");
    }
}
