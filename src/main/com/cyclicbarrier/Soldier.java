package main.com.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Soldier implements Runnable{
    private String name;
    private final CyclicBarrier cb;

    public Soldier(String name, CyclicBarrier cb) {
        this.name = name;
        this.cb = cb;
    }

    @Override
    public void run() {
        try{
            cb.await();
            System.out.println(name + " : shoot ZALPOM");
        }catch (BrokenBarrierException | InterruptedException e){
            e.printStackTrace();
        }
    }
}
