package ru.avalon.javapp.devj30.threadingemo;

public class Consumer extends AbstractEntity{
    public Consumer(Warehouse warehouse, String name) {
        super(warehouse, name);
    }

    @Override
    public int getGoodAount() {
        return 1 + rnd.nextInt(10);
    }

    @Override
    public void run() {
        while (true) {
            imitateJob(300, 500);
            warehouse.shipment(this);
        }
    }
}
