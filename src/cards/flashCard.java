package cards;

import exec.model.vo.Player;

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
        for(i = 0;i < 8;i++) {
            tmp = new Soldier("狂战士",30,50,1,3,36,3);
            soldiersValue4[j] = tmp;
            j++;
        }
        return 0;
    }
}

public class flashCard implements Runnable {
    public static Object lock;
    public Player user;
    public flashCard(Player a) {
        user = a;
    }
    public void run() {
        synchronized (lock) {
           int level = user.getLevel();
           
        }
    }
}
