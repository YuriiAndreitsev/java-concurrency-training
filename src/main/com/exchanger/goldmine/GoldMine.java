package main.com.exchanger.goldmine;

public class GoldMine {
    private int gold;

    public GoldMine(int gold) {
        this.gold = gold;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    @Override
    public String toString() {
        return "GoldMine {" +
                "gold=" + gold +
                '}';
    }

}
