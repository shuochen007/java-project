package cards;
/* @author hhw
 * the Solider
 * kind 使用位图法管理
 */

public class Soldier {
    public String name;
    public Attack attack;   //攻击
    public Blood blood;     //血量
    public int attackRange;  //攻击范围
    public int moveDis;     //移动能力
    public int value;       //旗子价值
    public int kind;        //兵种
    public boolean isbuy;   //
    public Soldier(String name, int basicattack, int basicblood, int basirange, int moviedis, int kind, int value) {
        attack = new Attack(basicattack);
        blood = new Blood(basicblood);
        this.attackRange = basirange;
        this.moveDis = moviedis;
        this.kind = kind;
        this.isbuy = false;
        this.name = name;
        this.value = value;
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
            if(buffer.special == 1) {
                attack.addAttack(this.attack.basicAttackNum);
            }
        }
        return 0;
    }
    public int toPrepare() {    //修改该旗子状态为备战区，会刷新其增益效果为无
        attack.flash();
        blood.flash();
        return 0;
    }
}
