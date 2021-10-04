package main.com.phaser;

import java.util.concurrent.Callable;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class PhasedCounter implements Callable<Integer> {
    private final String threadName;
    private final Phaser ph;
    private int initialCounter = 0;

    public PhasedCounter(String threadName, Phaser ph, int initialCounter) {
        this.threadName = threadName;
        this.ph = ph;
        this.initialCounter = initialCounter;
    }

    @Override
    public Integer call() throws Exception {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            System.out.println(threadName + " : This is phase " + ph.getPhase());
            TimeUnit.MILLISECONDS.sleep(1000);
            result += initialCounter * 10;
            System.out.println(threadName + " : computation = " + result);
            ph.arriveAndAwaitAdvance();
        }

        System.out.println(threadName + " : finished");
        return result;
    }
}
