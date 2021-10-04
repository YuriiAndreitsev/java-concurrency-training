package main.com.phaser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CounterMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Thread count = "+Thread.activeCount());
        ExecutorService es = Executors.newFixedThreadPool(4);
        Phaser phaser = new Phaser(4);
        int total = 0;
        List<Future<Integer>> results = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Future<Integer> result = es.submit(new PhasedCounter(i+1+"", phaser, i + 1));
            results.add(result);
        }


            total = results.stream().map(e-> {
                try {
                    return e.get();
                } catch (InterruptedException | ExecutionException interruptedException) {
                    interruptedException.printStackTrace();
                }
                return null;
            }).reduce(total, Integer::sum);

        System.out.println(total);

        es.shutdown();
    }
}
