package ru.avalon.javapp.devj30.threadingemo;

public class Producer extends AbstractEntity{
    public Producer(Warehouse warehouse, String name) {
        super(warehouse, name);
    }

    @Override
    public int getGoodAount() {
        return 5 + rnd.nextInt(10);
    }

    @Override
    public void run() {
        while (true) {
            warehouse.delivery(this);
            imitateJob(500, 800);
        }
    }
}
