package main.com.phaser;

import java.util.concurrent.Phaser;

public class PhaserExample implements Runnable {
    private Phaser p;
    private String name;

    public PhaserExample(Phaser p, String name) {
        this.p = p;
        this.name = name;
    }

    @Override
    public void run() {

        for (int i = 0; i < 3; i++) {
            System.out.println(name + " : Doing part of work n."+i);
            p.arriveAndAwaitAdvance();
        }

//        p.arriveAndDeregister();
//        System.out.println(name + " : unregistered");
        System.out.println(name + " : finished doing job");
    }
}
