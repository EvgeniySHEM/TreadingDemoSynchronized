package ru.avalon.javapp.devj30.threadingemo;

public class Warehouse {
    private int balance;

    public synchronized void delivery(Producer p) {
        int goodsAmt = p.getGoodAount();
        System.out.println(p.getName() + " has arrived to warehouse, " + goodsAmt + " units of goods delivered, " +
                balance + " units in the warehouse.");
        p.imitateJob(200, 300);

            balance += goodsAmt;
            notifyAll();


        System.out.println(balance + " units in the warehouse now, " + p.getName() + " leaves the warehouse.");

    }

    public synchronized void shipment(Consumer c) {
        int goodsAmt = c.getGoodAount();
        System.out.println(c.getName() + " has arrived to warehouse , " + goodsAmt + " units of goods are required, " +
                balance + " units in the warehouse.");

            while (balance < goodsAmt) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }

            c.imitateJob(100,200);
            balance -= goodsAmt;

        System.out.println(balance + " units in the warehouse now ");
    }
}
