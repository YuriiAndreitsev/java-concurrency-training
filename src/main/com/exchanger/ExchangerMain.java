package main.com.exchanger;

import java.sql.Time;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExchangerMain {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);
        Exchanger<Gold> ex = new Exchanger<>();
        for (int i = 0; i < 6; i++) {
            es.submit(new Worker("w" + i, ex, new Gold((i+1)*100)));
            TimeUnit.MILLISECONDS.sleep(1000);
        }

        es.shutdown();
    }
}
