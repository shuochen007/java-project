package exec.frame;

import javax.swing.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JPanel;

import exec.main.GameControl;
import exec.main.GameStart;
import exec.model.load.ElementLoader;
import exec.model.manager.ElementManager;
import exec.model.vo.*;
import exec.thread.GameThread;

/**
 * 游戏面板
 * @author Jenson
 * 窗体容器：画板类
 */
public class GameJPanel extends JPanel implements Runnable{
    private int w;
    private int h;
    private SettingJPanel sets;
    //构造函数
    public GameJPanel(){
        List<String> data = ElementLoader.getElementLoader().getGameInfoMap().get("windowSize");
        this.w = Integer.parseInt(data.get(0));
        this.h = Integer.parseInt(data.get(1));
         init();

    }
    private void init() {
        //添加设置按键
        JButton setButton = new JButton();
        setButton.setIcon(ElementLoader.getElementLoader().getImageMap().get("settings"));
        setButton.setBounds(5 * w / 6, 2 * h / 3, 180, 60);
        setButton.setBorderPainted(false);
        setButton.setFocusPainted(false);
        setButton.setContentAreaFilled(false);
        setButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                GameStart.changeJPanel("setting");
            }
        });
        this.add(setButton);
    }
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
        Map<String, List<SuperElement>> map = ElementManager.getManager().getMap();
        Set<String> set = map.keySet();
        Set<String> sortSet = new TreeSet<String>(ElementManager.getManager().getMapKeyComparator());
        sortSet.addAll(set);
        for(String key:sortSet) {
            List<SuperElement> list = map.get(key);
            for(int i=0; i<list.size(); i++) {
                list.get(i).showElement(g);
            }
        }
        //添加设置界面



        g.setFont(new Font("Times New Roman", Font.BOLD, 24));
        int allTime = GameThread.getAllTime()/1000;
        int munite = allTime / 60;
        int second = allTime % 60;
        String m;
        String s;
        if(munite < 10)
            m = "0" + Integer.toString(munite);
        else
            m = Integer.toString(munite);
        if(second<10)
            s = "0" + Integer.toString(second);
        else
            s = Integer.toString(second);
        g.drawString("Time: "+ m + ":" + s, 0, 3*64);
    }

    }

