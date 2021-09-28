package main.com.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Passenger implements Runnable {
    private final CountDownLatch cdl;
    private String name;

    public Passenger(CountDownLatch cdl, String name) {
        this.cdl = cdl;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name+" : Waiting for a bus");
            cdl.await();
            System.out.println(name + " : Entering the bus ...");
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " : Entered");
    }
}
