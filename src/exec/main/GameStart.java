package exec.main;

import exec.frame.GameFrame;
import exec.frame.GameJPanel;
import exec.thread.MusicThread;

public class GameStart {
    public static <GameMusicPlayer> void main(String[] args) {
        GameFrame frame = new GameFrame();
        GameJPanel panel = new GameJPanel();
        GameControl control = new GameControl();

        MusicThread musicPlayer = new MusicThread();
        musicPlayer.start();
    }
}
