package exec.frame;

import javax.swing.*;
import java.awt.*;
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
        this.setLayout(null);
        //添加地板
        Map<String, List<SuperElement>> elmenteMap = ElementManager.getManager().getMap();
        elmenteMap.get("floor").add(new floor(300,100,800,400));
        //添加设置按键
        JButton setButton = new JButton();
        setButton.setBounds( 1100 , 50 ,30, 30);
        ImageIcon imgs = new ImageIcon("img/bg/settings.png");
        imgs.setImage(imgs.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT));
        setButton.setIcon(imgs);
        setButton.setBorderPainted(false);
        setButton.setFocusPainted(false);
        setButton.setContentAreaFilled(false);
        setButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                GameStart.changeJPanel("setting");
            }
        });

        //hex
        ImageIcon img2 = new ImageIcon("img/player/hex.png");
        img2.setImage(img2.getImage().getScaledInstance(400,400, Image.SCALE_DEFAULT));
        final JLabel jLabel2 = new JLabel(img2);
        jLabel2.setText("hex");
        jLabel2.setVerticalTextPosition(JLabel.CENTER);
        jLabel2.setHorizontalTextPosition(JLabel.CENTER);
        jLabel2.setBounds(0, 0, w, h);
        jLabel2.setVisible(false);
        //添加购买经验值按钮
        JButton exeButton=new JButton();
        exeButton.setIcon(new ImageIcon("img/bg/buyexe.png"));
        exeButton.setBounds(200,  750, 210, 70);
        exeButton.setBorderPainted(false);
        exeButton.setFocusPainted(false);
        exeButton.setContentAreaFilled(false);
        exeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //增加经验值
            }
        });
        //添加刷新按钮
        JButton refreshButton=new JButton();
        refreshButton.setIcon(new ImageIcon("img/bg/refresh.png"));
        refreshButton.setBounds(200,  680, 210, 70);
        refreshButton.setBorderPainted(false);
        refreshButton.setFocusPainted(false);
        refreshButton.setContentAreaFilled(false);
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //刷新
            }
        });
        //添加hex按钮
        JButton hexButton=new JButton();
        hexButton.setIcon(new ImageIcon("img/bg/rect3.png"));
        hexButton.setBounds(1100,  800, 60, 20);
        hexButton.setBorderPainted(false);
        hexButton.setFocusPainted(false);
        hexButton.setContentAreaFilled(false);
        hexButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO 自动生成的方法存根
                if(!jLabel2.isVisible())
                    jLabel2.setVisible(true);
                else {
                    jLabel2.setVisible(false);
                }
            }
        });
        this.add(refreshButton);
        this.add(exeButton);
        this.add(setButton);
        this.add(hexButton);
        this.add(jLabel2);
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

