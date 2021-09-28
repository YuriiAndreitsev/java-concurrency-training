package main.com.countdownlatch;

import org.w3c.dom.ls.LSOutput;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CDLMain {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Thread.activeCount() before = "+Thread.activeCount());
        ExecutorService es = Executors.newFixedThreadPool(5);
        int counter = 3;
        CountDownLatch cdl = new CountDownLatch(counter);
        System.out.println("Thread.activeCount() after cdl and es = "+Thread.activeCount());
        es.submit(new Passenger(cdl, "Runner1"));
        es.submit(new Passenger(cdl, "Runner2"));
        es.submit(new Passenger(cdl, "Runner3"));
        es.submit(new Passenger(cdl, "Runner4"));
        es.submit(new Passenger(cdl, "Runner5"));

        for (int i = 0; i < counter; i++) {
            System.out.println("Count is "+cdl.getCount());
            TimeUnit.MILLISECONDS.sleep(1000);
            cdl.countDown();
        }
        System.out.println("Thread.activeCount() before shutdown = "+Thread.activeCount());
        while (Thread.activeCount()==2){

        }
        System.out.println("BUS in departing");
        es.shutdown();
    }
}
