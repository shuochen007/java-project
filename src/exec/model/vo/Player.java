package exec.model.vo;

/**
 * 玩家类
 * @author lsc
 * 主要涉及玩家的相关操作及规范
 */

public class Player {
    //玩家生命值
    private int health;
    //是否为电脑玩家
    private boolean AI;
    //是否存活
    private boolean alive;
    //近期战绩(几连胜连败)
    private int recentResults;
    //玩家拥有的金币值
    private int gold;
    //玩家自然金币增长速度(回合金,不算连胜连败)(GPR)
    private int goldPerRound;
    //玩家等级
    private int level;
    //玩家目前经验值
    private int exp;
    //构造函数
    public Player(boolean AI){
        this.health = 100;
        this.AI = AI;
        this.alive = true;
        this.recentResults = 0;
        this.gold = 5;
        this.goldPerRound = 1;
        this.level = 1;
        this.exp = 0;
    }
    //以下为get和set相关属性的方法(boolean型是is和set)
    public int getHealth() {
        return this.health;
    }
    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isAI() {
        return this.AI;
    }
    public void setAI(boolean AI){
        this.AI = AI;
    }

    public boolean isAlive(){
        return this.alive;
    }
    public void setAlive(boolean alive){
        this.alive = alive;
    }

    public int getRecentResults() {
        return this.recentResults;
    }
    public void setRecentResults(int recentResults) {
        this.recentResults = recentResults;
    }

    public int getGold() {
        return this.gold;
    }
    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getGoldPerRound() {
        return this.goldPerRound;
    }
    public void setGoldPerRound(int goldPerRound) {
        this.goldPerRound = goldPerRound;
    }

    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }
    public void setExp(int exp) {
        this.exp = exp;
    }

    //战斗结束之后，根据这场战斗结果，计算出新的最近战绩
    public void calRecentResults(int recentResult){
        int tempResult = getRecentResults();
        if(tempResult >= 0){
            if(recentResult == 1){
                tempResult++;
            }
            else{
                tempResult = -1;
            }
        }
        else{
            if(recentResult == 1){
                tempResult = 1;
            }
            else{
                tempResult--;
            }
        }
        setRecentResults(tempResult);
    }
    //将回合金从now增加到now+1,需要花费的金币
    public int calIncreaseGoldPerRoundCost(int now){
        //TODO 计算方式有待商榷
        return now;
    }
    //等级与经验的换算
    public int calExpToLevel(int level){
        //TODO 计算方式有待商榷
        return level * level + 4;
    }
    //花费一定数目的金币，让回合金+1
    public void increaseGoldPerRound(){
        int nowGPR = getGoldPerRound();
        int cost = calIncreaseGoldPerRoundCost(nowGPR);
        int beforeGold = getGold();
        int nowGold = beforeGold - cost;
        setGold(nowGold);
        setGoldPerRound(nowGPR + 1);
    }
    //升级(单纯的结果)
    public void upLevel(){
        int beforeLevel = getLevel();
        int nowLevel = beforeLevel++;
        setLevel(nowLevel);
    }
    //购买经验值(内部进行条件判断，满足条件则调用upLevel)
    public void buyExp() {
        int beforeLevel = getLevel();
        int beforeExp = getExp();
        int beforeGold = getGold();
        int afterGold = beforeGold - 4;
        setGold(afterGold);
        int afterExp = beforeExp + 4;
        if(afterExp > calExpToLevel(beforeLevel + 1)){
            upLevel();
        }
    }
    //金币产生的利息
    public int getInterest() {
        int interest = (getGold() % 10);
        if(interest > 5){
            interest = 5;
        }
        return interest;
    }
    //连胜连败额外获得的金币
    public int getResultsGold() {
        int result = getRecentResults();
        int extraGold = 0;
        if((1 < result && result <= 5 ) || ( -5 <= result && result < -1)){
            if(result > 0){
                extraGold = result;
            }
            else{
                extraGold = -result;
            }
        }
        else if((result > 5) || (result < -5)){
            extraGold = 5;
        }
        return extraGold;
    }
    //结算一个玩家一回合获得的总金币数
    public void addGold(){
        int beforeGold = this.getGold();
        int goldThisRound = this.goldPerRound + getInterest() + getResultsGold();
        setGold(beforeGold + goldThisRound);
    }
}
