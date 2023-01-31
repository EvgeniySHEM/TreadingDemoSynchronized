package ru.avalon.javapp.devj30.threadingemo;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public abstract class AbstractEntity extends Thread{
    protected final Warehouse warehouse;
    protected final Random rnd = ThreadLocalRandom.current();

    public AbstractEntity(Warehouse warehouse, String name) {
        super(name);
        this.warehouse = warehouse;
    }

    public void imitateJob(long minMs, long maxMs) {
        try {
            Thread.sleep((long) (minMs + (maxMs - minMs) * rnd.nextFloat()));
        } catch (InterruptedException e) {

        }
    }

    public abstract int getGoodAount();
}
