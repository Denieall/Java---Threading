package com.company;

import java.util.logging.Handler;

public class Main {

    public static void main(String[] args) {

        // Start thread by extending Thread class
        Hi obj1 = new Hi();
        obj1.start();

        // Creating an abstract class to start a new Thread --- shortcut of Hi
        Thread t1 = new Thread() {
            @Override
            public void run() {
                super.run();

                for (int i = 1; i <= 5; i++) {

                    System.out.println(Thread.currentThread().getName());

                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {

                    }

                }
            }
        };

        t1.start();

        // Creating a thread using runnable --- handle using a Handler
        Denieall dj = new Denieall();

        Thread t2 = new Thread(dj);
        t2.start();

        // Creating new thread using lamda expression
        Thread t3 = new Thread(() -> {
            Thread.currentThread().setName("Thread: Lamda");

            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName());

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
            }
        });

        t3.start();

        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }

    }
}

class Hi extends Thread {

    @Override
    public void run() {
        super.run();

        Thread.currentThread().setName("Thread Hi");

        for (int i = 1; i <= 5; i++) {

            System.out.println(Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }

        }
    }

}

class Denieall implements Runnable {

    @Override
    public void run() {

        synchronized (this) {
            try {
                wait(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Denieall's thread is done processing.");
        }


    }
}
