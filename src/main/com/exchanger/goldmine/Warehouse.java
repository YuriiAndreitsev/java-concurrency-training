package main.com.exchanger.goldmine;

public class Warehouse {
    private int gold;

    public Warehouse(int gold) {
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
        return "Warehouse{" +
                "gold=" + gold +
                '}';
    }
}
