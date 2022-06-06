package exec.main;

import exec.frame.GameFrame;
import exec.frame.GameJPanel;
import exec.thread.MusicThread;

/**
 * @author :lc
 * @date :2022-6-6
 * @Classname :游戏开始
 * @Description :游戏的启动入口
 * The main class of the game.
 */
public class GameStart {
    public static <GameMusicPlayer> void main(String[] args) {
        GameFrame frame = new GameFrame();
        GameJPanel panel = new GameJPanel();
        GameControl control = new GameControl();

        MusicThread musicPlayer = new MusicThread();
        musicPlayer.start();
    }
}
