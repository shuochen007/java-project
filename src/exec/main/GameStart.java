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

        MusicThread musicPlayer = new MusicThread();
        musicPlayer.start();
    }
}
