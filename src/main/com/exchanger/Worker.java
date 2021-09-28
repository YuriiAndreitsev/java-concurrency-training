package main.com.exchanger;

import java.util.concurrent.Exchanger;

public class Worker implements Runnable {
    private String name;
    private final Exchanger<Gold> ex;
    private Gold gold;

    public Worker(String name, Exchanger<Gold> ex, Gold gold) {
        this.name = name;
        this.ex = ex;
        this.gold = gold;
    }

    public Worker(String name, Exchanger<Gold> ex) {
        this.name = name;
        this.ex = ex;
    }


    @Override
    public void run() {
        try {
            System.out.println(name + " : transferring gold [" + gold.getGold() + "]");
            gold = ex.exchange(gold);
            System.out.println(name + " : received gold [" + gold.getGold() + "]");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
