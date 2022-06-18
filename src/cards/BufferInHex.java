package cards;

import exec.model.vo.Player;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BufferInHex {
    public int special;
    public BufferInSoldier buffer;
    public String message;
    public BufferInHex(int special, BufferInSoldier buffer, String message) {
        this.special = special;
        this.buffer = buffer;
        this.message = message;
    }
    @Override
    public String toString() {
        return this.message;
    }
    public static void main(String[] args) {
        BufferInHex[] test = new BufferInHex[9];
        AllBufferInHex.allBufferInHexInit();
        test = AllBufferInHex.getUserBufferInHex();
        System.out.println(AllBufferInHex.bufferLevel);
        for(BufferInHex v : test) {
            System.out.println(v); 
        }
    }
}

class AllBufferInHex {
   public static BufferInHex[] allBufferLevel1 = new BufferInHex[20];
   public static BufferInHex[] allBufferLevel2 = new BufferInHex[20];
   public static BufferInHex[] allBufferLevel3 = new BufferInHex[20];
   public static int bufferLevel;
   public static void allBufferInHexInit() {
       Random r = new Random();
       bufferLevel = r.nextInt(3) + 1;
       int randomnumberone;
       int randomnumbertwo;
       int j = 0;
       BufferInSoldier tmp;
       
       tmp = new BufferInSoldier(5,5,0,1);
       allBufferLevel1[j] = new BufferInHex(1,tmp,"为你的神射手们提供5攻击力，5生命值");
       j = 1;
       tmp = new BufferInSoldier(5,5,0,2);
       allBufferLevel1[j] = new BufferInHex(1,tmp,"为你的轻骑兵们提供5攻击力，5生命值");
       j = 2;
       tmp = new BufferInSoldier(5,5,0,4);
       allBufferLevel1[j] = new BufferInHex(1,tmp,"为你的战士们提供5攻击力，5生命值");
       j = 3;
       tmp = new BufferInSoldier(10,0,0,8);
       allBufferLevel1[j] = new BufferInHex(1,tmp,"为你的保镖们提供10攻击力");
       j = 4;
       tmp = new BufferInSoldier(0,10,0,8);
       allBufferLevel1[j] = new BufferInHex(1,tmp,"为你的保镖们提供10生命值");
       j = 5;
       tmp = new BufferInSoldier(10,0,0,16);
       allBufferLevel1[j] = new BufferInHex(1,tmp,"为你的重骑兵们提供10攻击力");
       j = 6;
       tmp = new BufferInSoldier(15,-10,0,16);
       allBufferLevel1[j] = new BufferInHex(1,tmp,"为你的重骑兵们提供15攻击力，但损失10生命值");
       j = 7;
       tmp = new BufferInSoldier(-8,25,0,8);
       allBufferLevel1[j] = new BufferInHex(1,tmp,"为你的保镖们提供25生命值，但损失8攻击力");
       j = 8;
       tmp = new BufferInSoldier(5,5,0,32);
       allBufferLevel1[j] = new BufferInHex(1,tmp,"为你的骑兵克星们提供5攻击力，5生命值");
       j = 9;
       tmp = new BufferInSoldier(5,0,0,3);
       allBufferLevel1[j] = new BufferInHex(1,tmp,"为你的神射手和轻骑兵们提供5攻击力");
       j = 10;
       tmp = new BufferInSoldier(0,5,0,24);
       allBufferLevel1[j] = new BufferInHex(1,tmp,"为你的保镖和重骑兵们提供5生命值");
       j = 11;
       tmp = new BufferInSoldier(2,2,0,63);
       allBufferLevel1[j] = new BufferInHex(1,tmp,"为你的全部棋子提供2攻击力，2生命值");
       j = 12;
       tmp = new BufferInSoldier(0,0,0,64);
       allBufferLevel1[j] = new BufferInHex(1,tmp,"该海克斯不具有任何效果");
       j = 13;
       randomnumberone = r.nextInt(5);
       randomnumbertwo = r.nextInt(5);
       tmp = new BufferInSoldier(randomnumberone,randomnumbertwo,0,63);
       allBufferLevel1[j] = new BufferInHex(1,tmp,"你的全部棋子获得一个0~4攻击力、0~4血量的随机加成，此加成将在本局唯一固定");
       j = 14;
       randomnumberone = r.nextInt(9) - 2;
       randomnumbertwo = r.nextInt(9) - 2;
       tmp = new BufferInSoldier(randomnumberone,randomnumbertwo,0,63);
       allBufferLevel1[j] = new BufferInHex(1,tmp,"你的全部棋子获得一个-2~6攻击力、-2~6血量的随机加成，此加成将在本局唯一固定");
       j = 15;
       randomnumberone = r.nextInt(6);
       randomnumberone = (int )Math.pow(2,randomnumberone);
       randomnumbertwo = r.nextInt(2);
       if(randomnumbertwo == 0)
           tmp = new BufferInSoldier(13,0,0,randomnumberone);
       else
           tmp = new BufferInSoldier(0,13,0,randomnumberone);
       allBufferLevel1[j] = new BufferInHex(1,tmp,"你的某种棋子将获得一个13攻击力或13血量的加成，此加成将在本局唯一固定");
       j = 16;
           tmp = new BufferInSoldier(0,0,0,0);
       allBufferLevel1[j] = new BufferInHex(5,tmp,"你获得额外8生命值");
       j = 17;
           tmp = new BufferInSoldier(0,5,0,63);
       allBufferLevel1[j] = new BufferInHex(1,tmp,"为你的全部棋子提供5生命值");
       
       j = 0;
       tmp = new BufferInSoldier(10,10,0,1);
       allBufferLevel2[j] = new BufferInHex(1,tmp,"为你的神射手们提供10攻击力，10生命值");
       j = 1;
       tmp = new BufferInSoldier(10,10,0,2);
       allBufferLevel2[j] = new BufferInHex(1,tmp,"为你的轻骑兵们提供10攻击力，10生命值");
       j = 2;
       tmp = new BufferInSoldier(10,10,0,4);
       allBufferLevel2[j] = new BufferInHex(1,tmp,"为你的战士们提供10攻击力，10生命值");
       j = 3;
       tmp = new BufferInSoldier(15,0,0,8);
       allBufferLevel2[j] = new BufferInHex(1,tmp,"为你的保镖们提供15攻击力");
       j = 4;
       tmp = new BufferInSoldier(0,20,0,8);
       allBufferLevel2[j] = new BufferInHex(1,tmp,"为你的保镖们提供20生命值");
       j = 5;
       tmp = new BufferInSoldier(15,0,0,16);
       allBufferLevel2[j] = new BufferInHex(1,tmp,"为你的重骑兵们提供15攻击力");
       j = 6;
       tmp = new BufferInSoldier(20,-10,0,16);
       allBufferLevel2[j] = new BufferInHex(1,tmp,"为你的重骑兵们提供20攻击力，但损失10生命值");
       j = 7;
       tmp = new BufferInSoldier(-12,30,0,8);
       allBufferLevel2[j] = new BufferInHex(1,tmp,"为你的保镖们提供30生命值，但损失12攻击力");
       j = 8;
       tmp = new BufferInSoldier(10,10,0,32);
       allBufferLevel2[j] = new BufferInHex(1,tmp,"为你的骑兵克星们提供10攻击力，10生命值");
       j = 9;
       tmp = new BufferInSoldier(10,0,0,3);
       allBufferLevel2[j] = new BufferInHex(1,tmp,"为你的神射手和轻骑兵们提供10攻击力");
       j = 10;
       tmp = new BufferInSoldier(0,10,0,24);
       allBufferLevel2[j] = new BufferInHex(1,tmp,"为你的保镖和重骑兵们提供10生命值");
       j = 11;
       tmp = new BufferInSoldier(6,6,0,63);
       allBufferLevel2[j] = new BufferInHex(1,tmp,"为你的全部棋子提供6攻击力，6生命值");
       j = 12;
       randomnumberone = r.nextInt(13);
       randomnumbertwo = r.nextInt(13);
       tmp = new BufferInSoldier(randomnumberone,randomnumbertwo,0,63);
       allBufferLevel2[j] = new BufferInHex(1,tmp,"你的全部棋子获得一个0~12攻击力、0~12血量的随机加成，此加成将在本局唯一固定");
       j = 13;
       randomnumberone = r.nextInt(21) - 4;
       randomnumbertwo = r.nextInt(21) - 4;
       tmp = new BufferInSoldier(randomnumberone,randomnumbertwo,0,63);
       allBufferLevel2[j] = new BufferInHex(1,tmp,"你的全部棋子获得一个-4~16攻击力、-4~16血量的随机加成，此加成将在本局唯一固定");
       j = 14;
       randomnumberone = r.nextInt(6);
       randomnumberone = (int )Math.pow(2,randomnumberone);
       randomnumbertwo = r.nextInt(2);
       if(randomnumbertwo == 0)
           tmp = new BufferInSoldier(20,0,0,randomnumberone);
       else
           tmp = new BufferInSoldier(0,20,0,randomnumberone);
       allBufferLevel2[j] = new BufferInHex(1,tmp,"你的某种棋子将获得一个20攻击力或20血量的加成，此加成将在本局唯一固定");
       j = 15;
       tmp = new BufferInSoldier(0,0,0,63);
       allBufferLevel2[j] = new BufferInHex(2,tmp,"你将在开局获得额外5金币");
       j = 16;
       tmp = new BufferInSoldier(0,0,0,63);
       allBufferLevel2[j] = new BufferInHex(3,tmp,"你每次受到伤害都将获得0-2的随机金币");
       j = 17;
       tmp = new BufferInSoldier(0,0,0,63);
       allBufferLevel2[j] = new BufferInHex(4,tmp,"当你生命值低于10时，你新上场的棋子获得额外20攻击、20生命");


       j = 0;
       tmp = new BufferInSoldier(15,15,0,1);
       allBufferLevel3[j] = new BufferInHex(1,tmp,"为你的神射手们提供15攻击力，15生命值");
       j = 1;
       tmp = new BufferInSoldier(15,15,0,2);
       allBufferLevel3[j] = new BufferInHex(1,tmp,"为你的轻骑兵们提供15攻击力，15生命值");
       j = 2;
       tmp = new BufferInSoldier(15,15,0,4);
       allBufferLevel3[j] = new BufferInHex(1,tmp,"为你的战士们提供15攻击力，15生命值");
       j = 3;
       tmp = new BufferInSoldier(20,0,0,8);
       allBufferLevel3[j] = new BufferInHex(1,tmp,"为你的保镖们提供20攻击力");
       j = 4;
       tmp = new BufferInSoldier(0,40,0,8);
       allBufferLevel3[j] = new BufferInHex(1,tmp,"为你的保镖们提供40生命值");
       j = 5;
       tmp = new BufferInSoldier(25,0,0,16);
       allBufferLevel3[j] = new BufferInHex(1,tmp,"为你的重骑兵们提供25攻击力");
       j = 6;
       tmp = new BufferInSoldier(35,-20,0,16);
       allBufferLevel3[j] = new BufferInHex(1,tmp,"为你的重骑兵们提供35攻击力，但损失20生命值");
       j = 7;
       tmp = new BufferInSoldier(-8,50,0,8);
       allBufferLevel3[j] = new BufferInHex(1,tmp,"为你的保镖们提供50生命值，但损失8攻击力");
       j = 8;
       tmp = new BufferInSoldier(20,20,0,32);
       allBufferLevel3[j] = new BufferInHex(1,tmp,"为你的骑兵克星们提供20攻击力，20生命值");
       j = 9;
       tmp = new BufferInSoldier(20,0,0,3);
       allBufferLevel3[j] = new BufferInHex(1,tmp,"为你的神射手和轻骑兵们提供20攻击力");
       j = 10;
       tmp = new BufferInSoldier(0,30,0,24);
       allBufferLevel3[j] = new BufferInHex(1,tmp,"为你的保镖和重骑兵们提供30生命值");
       j = 11;
       tmp = new BufferInSoldier(12,12,0,63);
       allBufferLevel3[j] = new BufferInHex(1,tmp,"为你的全部棋子提供12攻击力，12生命值");
       j = 12;
       randomnumberone = r.nextInt(27);
       randomnumbertwo = r.nextInt(23);
       tmp = new BufferInSoldier(randomnumberone,randomnumbertwo,0,63);
       allBufferLevel3[j] = new BufferInHex(1,tmp,"你的全部棋子获得一个0~26攻击力、0~22血量的随机加成，此加成将在本局唯一固定");
       j = 13;
       randomnumberone = r.nextInt(6);
       randomnumberone = (int )Math.pow(2,randomnumberone);
       randomnumbertwo = r.nextInt(2);
       if(randomnumbertwo == 0)
           tmp = new BufferInSoldier(30,0,0,randomnumberone);
       else
           tmp = new BufferInSoldier(0,60,0,randomnumberone);
       allBufferLevel3[j] = new BufferInHex(1,tmp,"你的某种棋子将获得一个30攻击力或60血量的加成，此加成将在本局唯一固定");
       j = 14;
       tmp = new BufferInSoldier(0,0,0,63);
       allBufferLevel3[j] = new BufferInHex(6,tmp,"你将在开局获得额外9金币");
       j = 15;
       tmp = new BufferInSoldier(0,0,0,63);
       allBufferLevel3[j] = new BufferInHex(7,tmp,"你每次受到伤害都将获得1-3的随机金币");
       j = 16;
       tmp = new BufferInSoldier(0,0,0,63);
       allBufferLevel3[j] = new BufferInHex(8,tmp,"你可以多放置一枚棋子");
       j = 17;
       tmp = new BufferInSoldier(0,0,0,63);
       allBufferLevel3[j] = new BufferInHex(9,tmp,"你可以多放置两枚棋子，且开局额外获得5金币，但你受到的伤害翻倍");
   }
   public static BufferInHex[] getUserBufferInHex() {
       Random r = new Random();
       int index;
       HashMap<Integer,BufferInHex> theRandomHex = new HashMap<>();
       BufferInHex[] ans = new BufferInHex[9];
       while(theRandomHex.size() < 9) {
           index = r.nextInt(18);
           if(bufferLevel == 1)
               theRandomHex.put(index,allBufferLevel1[index]);
           else if(bufferLevel == 2)
               theRandomHex.put(index,allBufferLevel2[index]);
           else if(bufferLevel == 3)
               theRandomHex.put(index,allBufferLevel3[index]);
       }
       index = 0;
       for(BufferInHex value : theRandomHex.values()) {
           ans[index] = value;
           index++;
       }
       return ans;
   }
}
