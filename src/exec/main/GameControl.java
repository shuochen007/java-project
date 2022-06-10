package exec.main;

/**
 * 游戏控制信息类
 * @ClassName: GameController
 * @Description: 包含游戏总体控制信息
 * @author: lc
 * @CreateDate: 2022年6月8日 15：13
 */
public class GameControl {
    private static boolean gameRunning = false;
    private static boolean twoPlayer;
    private static int npcNum;

    public static boolean isGameRunning() {
        return gameRunning;
    }
    public static void setGameRunning(boolean gameRunning) {
        GameControl.gameRunning = gameRunning;
    }
    public static boolean isTwoPlayer() {
        return twoPlayer;
    }
    public static void setTwoPlayer(boolean twoPlayer) {
        GameControl.twoPlayer = twoPlayer;
    }
    public static int getNpcNum() {
        return npcNum;
    }
    public static void setNpcNum(int npcNum) {
        GameControl.npcNum = npcNum;
    }
}
