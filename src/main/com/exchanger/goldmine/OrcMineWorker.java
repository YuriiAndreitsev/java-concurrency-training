package main.com.exchanger.goldmine;

import main.com.exchanger.Gold;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class OrcMineWorker implements Runnable {
    private String name;
    private final Exchanger<Integer> ex;
    private GoldMine goldMine;
    private int goldTransferCapacity = 3;
    private int cart = 0;

    public OrcMineWorker(String name, Exchanger<Integer> ex, GoldMine goldMine) {
        this.name = name;
        this.ex = ex;
        this.goldMine = goldMine;
    }


    @Override
    public void run() {
        try {
            while (goldMine.getGold() >= 0){
                goldMine.setGold(goldMine.getGold() - goldTransferCapacity);
                cart = ex.exchange(goldTransferCapacity);
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(name + " : Gold Mine has : " + goldMine.getGold() + "]");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}