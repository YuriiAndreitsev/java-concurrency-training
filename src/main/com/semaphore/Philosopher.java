package main.com.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Philosopher implements Runnable{
    public Philosopher(String name, Semaphore fork) {
        this.name = name;
        this.fork = fork;
    }

    private String name;
    public Philosopher(Semaphore fork) {
        this.fork = fork;
    }

    private final Semaphore fork;

    @Override
    public void run() {
        try {
            System.out.println(name +": Available permits = "+fork.availablePermits());
            fork.acquire(2);
            System.out.println(name +":Took 2 forks = "+fork.availablePermits());
            System.out.println(name +":Eating for 1.5 seconds");
            TimeUnit.MILLISECONDS.sleep(1500);
            System.out.println("Philosopher "+name+" finished eating");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(name +":Releasing permits");
            fork.release(2);
        }
    }
}
