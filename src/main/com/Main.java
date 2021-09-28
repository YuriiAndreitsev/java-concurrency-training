package main.com;

import main.com.semaphore.Philosopher;
import main.com.semaphore.Worker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(4);
        Semaphore semaphore = new Semaphore(4);

        es.submit(new Philosopher("Jack", semaphore));
        es.submit(new Philosopher("Bill", semaphore));
        es.submit(new Philosopher("George", semaphore));
        es.submit(new Philosopher("Fred", semaphore));
        es.submit(new Philosopher("Alex", semaphore));
//        es.submit(new Worker(semaphore));
//        es.submit(new Worker(semaphore));
//        es.submit(new Worker(semaphore));
//        es.submit(new Worker(semaphore));

        es.shutdown();
    }
}
