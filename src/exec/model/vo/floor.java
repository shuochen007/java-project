package exec.model.vo;

import exec.model.load.ElementLoader;
import exec.model.manager.ElementManager;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class floor extends SuperElement{
    private ImageIcon img;
    public floor(int x, int y, int w, int h){
        super(x, y, w, h);
        this.img= ElementLoader.getElementLoader().getImageMap().get("floor");
    }

    @Override
    public void showElement(Graphics g) {
        g.drawImage(img.getImage(),
                getX(), getY(),getW(),getH(),null	//屏幕左上角坐标
                );
    }

    @Override
    public void move() {

    }

    @Override
    public void destroy() {

    }

}
