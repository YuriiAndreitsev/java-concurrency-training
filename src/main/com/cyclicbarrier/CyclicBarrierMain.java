package main.com.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierMain {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(20);
        CyclicBarrier cb = new CyclicBarrier(5);

        try {
            for (int i = 0; i < 20; i++) {
                es.submit(new Soldier("s"+i, cb));
                System.out.println("s"+i);
                TimeUnit.MILLISECONDS.sleep(1000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
//        es.submit(new Soldier("s1", cb));
//        es.submit(new Soldier("s2", cb));
//        es.submit(new Soldier("s3", cb));
//        es.submit(new Soldier("s4", cb));
//        es.submit(new Soldier("s5", cb));
//        es.submit(new Soldier("s6", cb));

        es.shutdown();
    }
}
