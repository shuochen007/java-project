package cards;

import exec.model.vo.Player;

import java.util.Arrays;
import java.util.Random;

import static java.lang.Thread.sleep;

/* @author hhw
 * 本文件定义d牌 牌库
 * 首先需要实例化该进程的lock，
 * 为不影响进程的锁
 * 随后为每个用户创建自身的d牌对象
 * 需要d牌时，调用 对象.run
 * 其结果将被放置于 user下对应的数组
 * 另一种实现思路为
 * 将该进程的对象作为user的属性
 * 虽然效果相同，但提高了耦合度
 * 不利于拓展
 */

/* kind 1 神射手
   kind 2 轻骑兵
   kind 4 狂刃战士
   kind 8 保镖
   kind 16 重骑兵
   kind 32 骑兵克星
   
   1 民兵 4 18
   1 投石兵 1 18
   1 侦察兵 2 18
   1 长矛兵 32 18
   2 剑客 4 12
   2 游侠 16 12
   2 弩手 1 12
   2 卫士 8 32 12
   2 长枪兵 32 12
   3 雷欧娜 8 8
   3 骑射手 1 2 8
   3 翼骑兵 2 4 8
   3 狂战士 4 32 8
   4 战象 24 6
   4 投石机 1 6
   4 修仙者 6 6
   4 黑无常 4 6
   4 白无常 4 6
   5 末日机甲 4 8 16 3
   5 火箭炮 1 32 3
   5 伊泽瑞尔 1 2 3
   
   伟人： 黄忠 +15 attack
         成吉思汗
         亚索
         马老师
         努努  
         天使
         伽利略
         弗拉基米尔
         爪巴
* 
* */
class allCards{
    public static Soldier[] soldiersValue1 = new Soldier[72];
    public static Soldier[] soldiersValue2 = new Soldier[60];
    public static Soldier[] soldiersValue3 = new Soldier[32];
    public static Soldier[] soldiersValue4 = new Soldier[30];
    public static Soldier[] soldiersValue5 = new Soldier[9];
    public static Celebrity[] celebritys = new Celebrity[9];
    public static int AllCardsInit() {
        int i;
        int j = 0;
        Soldier tmp;
        Celebrity tmpp;
        BufferInSoldier tmpbuffer;
        for(i = 0;i < 18;i++) {
            tmp = new Soldier("民兵",15,25,1,2,4,1);  //民兵创建成功
            soldiersValue1[j] = tmp;
            j++;
        }
        for(i = 0;i < 18;i++) {
            tmp = new Soldier("投石兵",20,15,2,2,1,1);  
            soldiersValue1[j] = tmp;
            j++;
        }
        for(i = 0;i < 18;i++) {
            tmp = new Soldier("侦察兵",15,20,1,5,2,1);  
            soldiersValue1[j] = tmp;
            j++;
        }
        for(i = 0;i < 18;i++) {
            tmp = new Soldier("长矛兵",25,25,1,1,32,1);
            soldiersValue1[j] = tmp;
            j++;
        }
        j = 0;  //value 2 begin
        for(i = 0;i < 12;i++) {
            tmp = new Soldier("剑客",20,30,1,2,4,2);  
            soldiersValue2[j] = tmp;
            j++;
        }
        for(i = 0;i < 12;i++) {
            tmp = new Soldier("游侠",13,40,1,3,16,2);
            soldiersValue2[j] = tmp;
            j++;
        }
        for(i = 0;i < 12;i++) {
            tmp = new Soldier("弩手",30,20,3,2,12,2);
            soldiersValue2[j] = tmp;
            j++;
        }
        for(i = 0;i < 12;i++) {
            tmp = new Soldier("卫士",10,55,1,1,40,2);
            soldiersValue2[j] = tmp;
            j++;
        }
        for(i = 0;i < 12;i++) {
            tmp = new Soldier("长枪兵",25,40,1,1,32,2);
            soldiersValue2[j] = tmp;
            j++;
        }
        j = 0; //value 3 begin
        for(i = 0;i < 8;i++) {
            tmp = new Soldier("雷欧娜",18,80,1,1,8,3);
            soldiersValue3[j] = tmp;
            j++;
        }
        for(i = 0;i < 8;i++) {
            tmp = new Soldier("骑射手",40,20,3,3,3,3);
            soldiersValue3[j] = tmp;
            j++;
        }        
        for(i = 0;i < 8;i++) {
            tmp = new Soldier("翼骑兵",30,45,1,5,6,3);
            soldiersValue3[j] = tmp;
            j++;
        }
        for(i = 0;i < 8;i++) {
            tmp = new Soldier("狂战士",30,50,1,3,36,3);
            soldiersValue3[j] = tmp;
            j++;
        }
        j = 0; //value 4 begin
        for(i = 0;i < 6;i++) {
            tmp = new Soldier("战象",20,90,1,2,24,4);
            soldiersValue4[j] = tmp;
            j++;
        }
        for(i = 0;i < 6;i++) {
            tmp = new Soldier("投石机",45,30,3,2,1,4);
            soldiersValue4[j] = tmp;
            j++;
        }
        for(i = 0;i < 6;i++) {
            tmp = new Soldier("修仙者",35,55,1,3,6,4);
            soldiersValue4[j] = tmp;
            j++;
        }
        for(i = 0;i < 6;i++) {
            tmp = new Soldier("黑无常",45,45,1,3,4,4);
            soldiersValue4[j] = tmp;
            j++;
        }
        for(i = 0;i < 6;i++) {
            tmp = new Soldier("白无常",40,50,1,3,4,4);
            soldiersValue4[j] = tmp;
            j++;
        }
        j = 0; //value 5 begin
        for(i = 0;i < 3;i++) {
            tmp = new Soldier("末日机甲",50,60,1,3,20,5);
            soldiersValue5[j] = tmp;
            j++;
        }
        for(i = 0;i < 3;i++) {
            tmp = new Soldier("火箭炮",65,40,4,3,33,5);
            soldiersValue5[j] = tmp;
            j++;
        }
        for(i = 0;i < 3;i++) {
            tmp = new Soldier("伊泽瑞尔",60,50,1,3,3,5);
            soldiersValue5[j] = tmp;
            j++;
        }
        j = 0; //伟人begin
        tmpbuffer = new BufferInSoldier(10,0,0,1);
        tmpp = new Celebrity("黄忠",tmpbuffer,"为所有神射手增加10攻击力");
        celebritys[j] = tmpp;
        j++;
        tmpbuffer = new BufferInSoldier(10,0,0,2);
        tmpp = new Celebrity("成吉思汗",tmpbuffer,"为所有轻骑兵增加10攻击力");
        celebritys[j] = tmpp;
        j++;
        tmpbuffer = new BufferInSoldier(5,5,0,4);
        tmpp = new Celebrity("亚索",tmpbuffer,"为所有狂刃战士增加5攻击力、5生命值");
        celebritys[j] = tmpp;
        j++;
        tmpbuffer = new BufferInSoldier(0,0,1,8);
        tmpp = new Celebrity("马老师",tmpbuffer,"你的保镖攻击力翻倍，但他们的血量减半");
        celebritys[j] = tmpp;
        j++;
        tmpbuffer = new BufferInSoldier(-5,20,0,16);
        tmpp = new Celebrity("努努",tmpbuffer,"你的重骑兵损失5攻击力，增加20生命值");
        celebritys[j] = tmpp;
        j++;
        tmpbuffer = new BufferInSoldier(5,10,0,32);
        tmpp = new Celebrity("天使",tmpbuffer,"你的骑兵克星增加5攻击力，10生命值");
        celebritys[j] = tmpp;
        j++;
        tmpbuffer = new BufferInSoldier(5,0,0,63);
        tmpp = new Celebrity("伽利略",tmpbuffer,"你的所有单位增加5攻击力");
        celebritys[j] = tmpp;
        j++;
        tmpbuffer = new BufferInSoldier(-5,20,0,63);
        tmpp = new Celebrity("弗拉基米尔",tmpbuffer,"你的所有单位减少5攻击力，增加20生命值");
        celebritys[j] = tmpp;
        j++;
        tmpbuffer = new BufferInSoldier(0,10,0,63);
        tmpp = new Celebrity("云顶",tmpbuffer,"你的所有单位增加10生命值");
        celebritys[j] = tmpp;
        for(i = 0;i < 72;i++)
            System.out.println(soldiersValue1[i]);
        for(i = 0;i < 60;i++)
            System.out.println(soldiersValue2[i]);
        for(i = 0;i < 32;i++)
            System.out.println(soldiersValue3[i]);
        for(i = 0;i < 30;i++)
            System.out.println(soldiersValue4[i]);
        for(i = 0;i < 9;i++)
            System.out.println(soldiersValue5[i]);
        for(i = 0;i < 9;i++)
            System.out.println(celebritys[i]);
        return 0;
    }
}

public class flashCard implements Runnable {
    public static Object lock;
    public Player user;
    public flashCard(Player a)
    {
        lock = new Object();
        this.user = a;
    }
    public static void main(String[] args)  {
        lock = new Object();
        allCards.AllCardsInit();
        Player a = new Player(false);
        Player b = new Player(false);
        Player c = new Player(false);
        getSoliderShop(a);
        getSoliderShop(b);
        getSoliderShop(c);
    }
    public static boolean getSoliderShop(Player user) {
        flashCard flashcard = new flashCard(user);
        new Thread(flashcard).start();
        try {
            sleep(50);
        } catch (InterruptedException e) {
            System.out.println(e);
            return false;
        }
        System.out.println(Arrays.toString(user.shop));
        System.out.println(user.celebrityShop);
        return true;
    }
    public void run() {
        synchronized (lock) {
            int i;
            int j;
            int soliderValue;
            int soliderIndex;
            int celebrityIndex;
            int flag;
            Random r = new Random();
            int level = user.getLevel();
            for(i = 0;i < 5;i++) {
                if(user.shop[i] != null)
                    user.shop[i].inshop = false;
            }
            for(i = 0;i < 5;i++) {
                flag = 0;
                soliderValue = r.nextInt(5) + 1;
                if(soliderValue == 1) {
                    for(j = 0;j < 72;j++) {
                        if(!allCards.soldiersValue1[j].isBuy && !allCards.soldiersValue1[j].inshop) {
                            flag = 1;
                            break;
                        }
                    }
                    while(flag == 1) {
                        soliderIndex = r.nextInt(72);
                        if(!allCards.soldiersValue1[soliderIndex].isBuy && !allCards.soldiersValue1[soliderIndex].inshop) {
                            user.shop[i] = allCards.soldiersValue1[soliderIndex];
                            flag = 2;
                            break;
                        }
                    }
                    if(flag == 0) i--;
                }
                else if(soliderValue == 2) {
                    for(j = 0;j < 60;j++) {
                        if(!allCards.soldiersValue1[j].isBuy && !allCards.soldiersValue1[j].inshop) {
                            flag = 1;
                            break;
                        }
                    }
                    while(flag == 1) {
                        soliderIndex = r.nextInt(60);
                        if(!allCards.soldiersValue1[soliderIndex].isBuy && !allCards.soldiersValue1[soliderIndex].inshop) {
                            user.shop[i] = allCards.soldiersValue2[soliderIndex];
                            flag = 2;
                            break;
                        }
                    }
                    if(flag == 0) i--;
                }
                else if(soliderValue == 3) {
                    for(j = 0;j < 32;j++) {
                        if(!allCards.soldiersValue3[j].isBuy) {
                            flag = 1;
                            break;
                        }
                    }
                    while(flag == 1) {
                        soliderIndex = r.nextInt(32);
                        if(!allCards.soldiersValue3[soliderIndex].isBuy && !allCards.soldiersValue3[soliderIndex].inshop) {
                            user.shop[i] = allCards.soldiersValue3[soliderIndex];
                            flag = 2;
                            break;
                        }
                    }
                    if(flag == 0) i--;
                }
                else if(soliderValue == 4) {
                    for(j = 0;j < 30;j++) {
                        if(!allCards.soldiersValue4[j].isBuy) {
                            flag = 1;
                            break;
                        }
                    }
                    while(flag == 1) {
                        soliderIndex = r.nextInt(30);
                        if(!allCards.soldiersValue4[soliderIndex].isBuy && !allCards.soldiersValue4[soliderIndex].inshop) {
                            user.shop[i] = allCards.soldiersValue4[soliderIndex];
                            flag = 2;
                            break;
                        }
                    }
                    if(flag == 0) i--;
                }
                else {
                    for(j = 0;j < 9;j++) {
                        if(!allCards.soldiersValue5[j].isBuy) {
                            flag = 1;
                            break;
                        }
                    }
                    while(flag == 1) {
                        soliderIndex = r.nextInt(9);
                        if(!allCards.soldiersValue5[soliderIndex].isBuy && !allCards.soldiersValue5[soliderIndex].inshop) {
                            user.shop[i] = allCards.soldiersValue5[soliderIndex];
                            flag = 2;
                            break;
                        }
                    }
                    if(flag == 0) i--;
                }
            }
            for(i = 0;i < 5;i++) {
                user.shop[i].inshop = true;
            }
            if(user.celebrityShop != null)
                user.celebrityShop.inshop = false;
            while(true) {
                celebrityIndex = r.nextInt(9);
                if(!allCards.celebritys[celebrityIndex].isBuy && !allCards.celebritys[celebrityIndex].inshop) {
                    allCards.celebritys[celebrityIndex].inshop = true;
                    user.celebrityShop = allCards.celebritys[celebrityIndex];
                    break;
                }
            }
        }
    }
}
