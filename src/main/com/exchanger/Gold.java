package main.com.exchanger;

public class Gold {
    private int gold;

    @Override
    public String toString() {
        return "Gold{" +
                "gold=" + gold +
                '}';
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public Gold(int gold) {
        this.gold = gold;
    }
}
