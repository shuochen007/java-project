package exec.frame;

import javax.swing.*;
import java.awt.Font;
import java.awt.Graphics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JPanel;

import exec.main.GameControl;
import exec.model.manager.ElementManager;
import exec.model.vo.*;
import exec.thread.GameThread;

/**
 * 游戏面板
 * @author Jenson
 * 窗体容器：画板类
 */
public class GameJPanel extends JPanel implements Runnable{

    //	显示画板内容，绘画
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        gameRuntime(g);
    }

    @Override
    public void run() {
        while(GameControl.isGameRunning()) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint(); //每隔100毫秒刷新画板
        }
    }

    //展示元素管理器中所有的元素
    public void gameRuntime(Graphics g) {

    }
}
