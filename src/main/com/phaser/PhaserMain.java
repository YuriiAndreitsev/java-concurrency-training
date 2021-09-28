package main.com.phaser;

import main.com.cyclicbarrier.Soldier;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class PhaserMain {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(20);

        Phaser p = new Phaser(3);

        try {
            for (int i = 0; i < 9; i++) {
                es.submit(new PhaserExample(p, "phaser"+i));
                System.out.println("phaser"+i);
                TimeUnit.MILLISECONDS.sleep(1000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        es.shutdown();
    }
}
