package main.com.exchanger.goldmine;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameMain {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        Exchanger<Integer> exchanger = new Exchanger<>();
GoldMine mine = new GoldMine(333);
        OrcMineWorker orcMineWorker = new OrcMineWorker("mine worker", exchanger, mine);
        OrcWarehouseWorker orcWarehouseWorker = new OrcWarehouseWorker("wh worker", exchanger, new Warehouse(0), mine);

        es.submit(orcMineWorker);
        es.submit(orcWarehouseWorker);

        es.shutdown();

    }
}
