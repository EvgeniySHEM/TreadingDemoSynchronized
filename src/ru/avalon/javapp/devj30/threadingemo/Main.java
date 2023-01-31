package ru.avalon.javapp.devj30.threadingemo;

public class Main {
    public static void main(String[] args) {
        Warehouse w = new Warehouse();
        AbstractEntity[] entities = {
                new Producer(w, "p1"),
                new Producer(w, "p2"),
                new Producer(w, "p3"),
                new Consumer(w, "c1"),
                new Consumer(w, "c2"),
                new Consumer(w, "c3"),
                new Consumer(w, "c4"),
                new Consumer(w, "c5"),
                new Consumer(w, "c6"),
                new Consumer(w, "c7")
        };

        for (AbstractEntity entity : entities) {
            entity.start();
        }
    }
}
