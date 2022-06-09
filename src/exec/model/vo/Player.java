package exec.model.vo;

import java.util.HashMap;

/**
 * 玩家类
 * @author lsc
 * 主要涉及玩家的相关操作及规范
 */
//只是不报错,完工时不用这个
class Soldier {
    private int value;

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
}

class Celebrity{
    private int value;

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
}

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
    //玩家场上棋子容量
    private int boardCapacity;
    //玩家场上棋子数量
    private int onBoardNum;
    //玩家备战席棋子数量
    private int onPrepareNum;
    //玩家持有的棋子队列,key=棋子,value=isBoard
    private HashMap<Soldier, Boolean> soldierList = new HashMap<>();
    //玩家拥有的伟人
    private Celebrity celebrity;
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
        this.soldierList = null;
        this.celebrity = null;
        this.onPrepareNum = 0;
        this.onBoardNum = 0;
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
        return this.level;
    }
    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return this.exp;
    }
    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getBoardCapacity() {
        return this.boardCapacity;
    }
    public void setBoardCapacity(int boardCapacity) {
        this.boardCapacity = boardCapacity;
    }

    public int getOnBoardNum() {
        return onBoardNum;
    }
    public void setOnBoardNum(int onBoardNum) {
        this.onBoardNum = onBoardNum;
    }

    public int getOnPrepareNum() {
        return onPrepareNum;
    }
    public void setOnPrepareNum(int onPrepareNum) {
        this.onPrepareNum = onPrepareNum;
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
        int nowLevel = beforeLevel + 1;
        int beforeCapacity = getBoardCapacity();
        int nowCapacity = beforeCapacity + 1;
        setLevel(nowLevel);
        setBoardCapacity(nowCapacity);
    }
    //购买经验值(内部进行条件判断，满足条件则调用upLevel)
    public void buyExp() {
        int beforeLevel = getLevel();
        int beforeExp = getExp();
        int beforeGold = getGold();
        int afterGold = beforeGold - 4;
        setGold(afterGold);
        int afterExp = beforeExp + 4;
        setExp(afterExp);
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
    //购买棋子,备战席容量为9
    public void buySoldier(Soldier soldier) {
        if(getOnPrepareNum() <= 9) {
            int beforeGold = getGold();
            if(beforeGold >= soldier.getValue()) {
                int afterGold = beforeGold - soldier.getValue();
                setGold(afterGold);
                this.soldierList.put(soldier, false);
            }
            else{
                //TODO 您的金币不足！
            }
        }
        else{
            //TODO 备战席已满，无法再容纳更多棋子！
        }
    }
    //出战
    public void prepareToBoard(Soldier soldier) {
        int beforePrepare = getOnPrepareNum();
        int beforeBoard = getOnBoardNum();
        if(beforeBoard < this.boardCapacity) {
            int afterPrepare = beforePrepare - 1;
            setOnPrepareNum(afterPrepare);
            int afterBoard = beforeBoard + 1;
            setOnBoardNum(afterBoard);
            this.soldierList.put(soldier,true);
        }
        else{
            //TODO 场上已满，无法再容纳更多棋子！
        }
    }
    //休战
    public void boardToPrepare(Soldier soldier){
        int beforePrepare = getOnPrepareNum();
        int beforeBoard = getOnBoardNum();
        if(beforePrepare < 9) {
            int afterBoard = beforeBoard - 1;
            setOnBoardNum(afterBoard);
            int afterPrepare = beforePrepare + 1;
            setOnPrepareNum(afterPrepare);
            this.soldierList.put(soldier,false);
        }
        else{
            //TODO 备战席已满，无法再容纳更多棋子！
        }
    }
    //出售棋子
    public void soldSoldier(Soldier soldier) {
        int beforePrepare = getOnPrepareNum();
        int afterPrepare = beforePrepare - 1;
        setOnPrepareNum(afterPrepare);
        this.soldierList.remove(soldier);
        int beforeGold = getGold();
        int afterGold = beforeGold + soldier.getValue();
        setGold(afterGold);
    }
    //购买伟人
    public void buyCelebrity(Celebrity celebrity){
        if(this.celebrity == null){
            int beforeGold = getGold();
            if(beforeGold >= celebrity.getValue()) {
                int afterGold = beforeGold - celebrity.getValue();
                setGold(afterGold);
                this.celebrity = celebrity;
            }
            else{
                //TODO 您的金币不足！
            }
        }
        else{
            //TODO 您只能拥有一个伟人！
        }
    }
    //出售伟人
    public void soldCelebrity(Celebrity celebrity){
        int beforeGold = getGold();
        int afterGold = beforeGold + celebrity.getValue();
        setGold(afterGold);
        this.celebrity = null;
    }
    //战斗结束后受到伤害
    public void getHurt(int enemyAliveNum) {
        int beforeHealth = getHealth();
        int afterHealth = beforeHealth - (enemyAliveNum * this.getLevel());
        setHealth(afterHealth);
    }
    //刷新商店
    public void refreshShop() {
        int beforeGold = getGold();
        if(beforeGold >= 2){
            int afterGold = beforeGold - 2;
            setGold(afterGold);
            //TODO 刷新商店
        }
        else{
            //TODO 您的金币不足！
        }
    }
}
