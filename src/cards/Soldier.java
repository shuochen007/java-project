package cards;
/* @author hhw
 * the Solider
 * kind 使用位图法管理
 */

import java.util.ArrayList;
import java.util.Queue;

public class Soldier {
    public String name;
    public Attack attack;   //攻击
    public Blood blood;     //血量
    public int attackRange;  //攻击范围
    public int moveDis;     //移动能力
    public int value;       //旗子价值
    public int kind;        //兵种
    public boolean isBuy;   //
    public boolean inshop;  
    public String img; 
    public Soldier(String name, int basicattack, int basicblood, int basirange, int moviedis, int kind, int value,String img) {
        attack = new Attack(basicattack);
        blood = new Blood(basicblood);
        this.attackRange = basirange;
        this.moveDis = moviedis;
        this.kind = kind;
        this.isBuy = false;
        this.inshop = false;
        this.name = name;
        this.value = value;
        this.img = img;
    }
    public int getValue() {
        return this.value;
    }
    public int getBuffer(BufferInSoldier buffer) {  //上场时用于计算增益效果
        if(buffer.special == 0) {
            if((buffer.kind & this.kind) != 0) {
                attack.addAttack(buffer.attackChange);
                blood.addBlood(buffer.bloodChange); 
            }
            return 0;   
        }
        else {                                      //处理特殊增益类
            if(buffer.special == 1) { //马老师的特殊效果
                if((buffer.kind & this.kind) != 0) {
                    attack.addAttack(this.attack.basicAttackNum);   
                    blood.addBlood(-this.blood.basicBloodNum/2); 
                }
            }
        }
        return 0;
    }
    public int toPrepare() {    //修改该旗子状态为备战区，会刷新其增益效果为无
        attack.flash();
        blood.flash();
        return 0;
    }
    public ArrayList<String> getMessage() {
        ArrayList<String> ans = new ArrayList<>();
        if((this.kind & 1) != 0)
            ans.add("神射手");
        if((this.kind & 2) != 0)
            ans.add("轻骑兵");
        if((this.kind & 4) != 0)
            ans.add("狂刃战士");
        if((this.kind & 8) != 0)
            ans.add("保镖");
        if((this.kind & 16) != 0)
            ans.add("重骑兵");
        if((this.kind & 32) != 0)
            ans.add("骑兵克星");
        return ans;
    }
    @Override
    public String toString() {
        return this.name + "攻击力为: " + attack.basicAttackNum + " 血量为：" + blood.basicBloodNum;
    }
    public String getImg() {
        return this.img;
    }
}
