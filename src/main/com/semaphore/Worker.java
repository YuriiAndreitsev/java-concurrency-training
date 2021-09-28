package main.com.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Worker implements Runnable {

    public Worker(Semaphore s) {
        this.s = s;
    }

    private final Semaphore s;

    @Override
    public void run() {
        try {
            s.acquire();
            for (int i = 0; i < 10; i++) {
                System.out.printf("%s1 working iteration [%d2]"
                        +System.lineSeparator(), Thread.currentThread().getName(), i);
                TimeUnit.MILLISECONDS.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            s.release();
        }
    }
}
