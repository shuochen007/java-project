package cards;
/*@author hhw 
 * the buffer to Solider
 */

public class BufferInSoldier {
    public int attackChange;    //攻击
    public int bloodChange;     //血量
    public int kind;            //适用兵种
    public int special;         /*特殊增益
                                  当其为特殊增益时
                                  我们不再通过attackChange描述该效果
                                  例如 special 为 1
                                  代表攻击力翻倍 
                                  具体实现于Solider类
                                */
    public BufferInSoldier(int attackChange,int bloodChange, int special) {
        this.attackChange = attackChange;
        this.bloodChange = bloodChange;
        this.special = special;
    }
    @Override
    public String toString() {
        return "attackChange is " + attackChange + " bloodChange is " + bloodChange;
    }
}
