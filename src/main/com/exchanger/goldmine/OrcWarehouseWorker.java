package main.com.exchanger.goldmine;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class OrcWarehouseWorker implements Runnable {
    private String name;
    private final Exchanger<Integer> ex;
    private Warehouse warehouse;
    private int cart = 0;
    private int receivedGold = 0;
    private final GoldMine mine;

    public OrcWarehouseWorker(String name, Exchanger<Integer> ex, Warehouse warehouse, GoldMine mine) {
        this.name = name;
        this.ex = ex;
        this.warehouse = warehouse;
        this.mine = mine;
    }

    @Override
    public void run() {
        while (mine.getGold() >= 0) {
            try {
                receivedGold = ex.exchange(cart);
                TimeUnit.MILLISECONDS.sleep(100);
                warehouse.setGold(warehouse.getGold()+receivedGold);
                System.out.println(name + " : Warehouse has : " + warehouse + "]");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}