package cards;

public class BufferInHex {
    public int level;
    public BufferInSoldier buffer;
    public BufferInHex(int level, BufferInSoldier buffer) {
        this.level = level;
        this.buffer = buffer;
    }
}

class AllBufferInHex {
   public static BufferInHex[] allBuffer = new BufferInHex[20];
   public static void allBufferInHexInit() {
       
   }
}
