package exec.frame;



import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import exec.main.GameControl;
import exec.main.GameStart;
import exec.model.load.ElementLoader;
import exec.model.load.ElementLoader;
import exec.thread.MusicThread;

public class SettingJPanel extends JPanel{
    private ImageIcon img;
    private int w;
    private int h;

    //构造函数
    public SettingJPanel(){
        List<String> data = ElementLoader.getElementLoader().getGameInfoMap().get("windowSize");
        this.img = ElementLoader.getElementLoader().getImageMap().get("sets");
        this.w = Integer.parseInt(data.get(0));
        this.h = Integer.parseInt(data.get(1));
        init();
    }

    private void init() {
        this.setLayout(null);
        JLabel jLabel = new JLabel(img);
        img.setImage(img.getImage().getScaledInstance(w, h,Image.SCALE_DEFAULT ));
        jLabel.setBounds(0, 0, w, h);
        ImageIcon img2 = ElementLoader.getElementLoader().getImageMap().get("musiccontrol");
        img2.setImage(img2.getImage().getScaledInstance(130,130,Image.SCALE_DEFAULT));
        //添加音乐按键
        JButton musicButton = new JButton();
        musicButton.setIcon(ElementLoader.getElementLoader().getImageMap().get("musiccontrol"));
        musicButton.setBounds(w/6, h/2, 180, 60);;
        musicButton.setBorderPainted(false);
        musicButton.setFocusPainted(false);
        musicButton.setContentAreaFilled(false);
        musicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if(MusicThread.stop==0) {
                    try {
                        GameStart.stopMusic();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    try {
                        GameStart.keepMusic();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        //添加返回按键
        JButton backButton = new JButton();
        backButton.setIcon(ElementLoader.getElementLoader().getImageMap().get("backtogame"));
        backButton.setBounds(w/6, h/3, 180, 60);;
        backButton.setBorderPainted(false);
        backButton.setFocusPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                GameStart.changeJPanel("game");
            }
        });

        this.add(musicButton);
        this.add(backButton);
        this.add(jLabel);

        this.setVisible(true);
        this.setOpaque(true);
    }

}
