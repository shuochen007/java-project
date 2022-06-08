package cards;
/* @author hhw
   基本属性类
   每个属性有三个表现
    1. 属性名num 为计算出的总数值
    2. basic属性名num， 为初始化的基础数值
    3. 属性名round，为回合中用于战斗的暂时属性值，每回合重置
    对回合战斗中值的修改，可以直接进行访问修改以简化代码
 */
 

// 接口 flash，用于刷新每回合的数值
interface flash {
     boolean flashRound();
}
class Attack implements flash {
    public int attackNum;  //表现出的总攻击，将附加值附加于此
    public int attactRound;
    public final int basicAttackNum; //基础攻击力，设定后无法修改
    public Attack(int attackNumber) {
        this.basicAttackNum = attackNumber;
        this.attackNum = this.basicAttackNum;
    }
    /*
     *   修改总攻击力
     *   攻击力不能小于0
    * */
    public boolean addAttack(int addNumber) {
        this.attackNum += addNumber;
        if(this.attackNum < 0) {
            this.attackNum = addNumber;
            System.out.println("attack is less than zero");
            return false;   //发生此情况，手动将攻击力设置为1
        }
        return true;
    }
    @Override
    public boolean flashRound() {
        this.attactRound = this.attackNum;       
        return true;
    }
}

class Blood implements flash {
    public int bloodNum;  //表现出的总血量，将附加值附加于此
    public int bloodRound;
    public final int basicBloodNum; //基础血量，设定后无法修改
    public Blood(int bloodNum) {
        this.basicBloodNum = bloodNum;
        this.bloodNum = this.basicBloodNum;
    }
    public boolean addBlood(int addNumber) {
        this.bloodNum += addNumber;
        if(this.bloodNum < 0) {
            this.bloodNum -= addNumber;
            System.out.println("attack is less than zero");
            return false;
        }
        return true;
    }
    @Override
    public boolean flashRound() {
        this.bloodRound= this.bloodNum;
        return true;
    }
}
