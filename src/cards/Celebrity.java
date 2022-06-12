package cards;

public class Celebrity{
    public boolean isBuy;
    public boolean inshop;
    public String name;
    public BufferInSoldier buffer;
    public String message;  //用于描述该伟人效果
    public String img;
    private int value;
    public Celebrity(String name, BufferInSoldier buffer, String message,String img) {
        this.isBuy = false;
        this.inshop = false;
        this.name = name;
        this.buffer = buffer;
        this.message = message;
        this.img = img;
    }
    public BufferInSoldier getBuffer() { return this.buffer; }
    public int getValue() {
        return this.value;
    }
    public void setValue(int value) {
        this.value = value;
        return ;
    }
    public String getmes() { 
        return this.message; 
    }
    @Override 
    public String toString() {
        return this.name;
    }
    public String getImg() {
        return this.img;
    }
}
