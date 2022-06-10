package cards;
/* @author hhw
   基本属性类
   每个属性有三个表现
    1. 属性名num 为计算出的总数值
    2. basic属性名num， 为初始化的基础数值
    3. 属性名round，为回合中用于战斗的暂时属性值，每回合重置
    对回合战斗中值的修改，可以直接进行访问修改以简化代码
 */
 

// 接口 flash，用于刷新
interface flash {
     boolean flashRound();  //每回合的刷新，会修改attackRound
     boolean flash();       //上下场的刷新，会修改attackNum
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
            this.attackNum = 1;
            System.out.println("attack is less than zero, we change it to 1");
            return false;   //发生此情况，手动将攻击力设置为1
        }
        return true;
    }
    public int getBasicAttackNum() {
        return this.basicAttackNum;
    }
    @Override
    public boolean flashRound() {
        this.attactRound = this.attackNum;       
        return true;
    }
    @Override
    public boolean flash() {
        this.attackNum = this.basicAttackNum;
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
            this.bloodNum = 1;
            System.out.println("blood is less than zero, we change it ro 1");
            return false;
        }
        return true;
    }
    public int getBasicBloodNum() {
        return this.basicBloodNum;
    }
    @Override
    public boolean flashRound() {
        this.bloodRound= this.bloodNum;
        return true;
    }
    @Override
    public boolean flash() {
        this.bloodNum = this.basicBloodNum;
        return true;
    }
}
