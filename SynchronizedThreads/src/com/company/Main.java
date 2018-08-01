package com.company;

import java.awt.*;
import java.util.ArrayList;

public class Main {

    static int counter = 0;

    // Without synchronized keyword all the threads will be accessing the methods at the same time
    public synchronized static void processing() throws InterruptedException {

        Thread.sleep(10000);

        System.out.println(Thread.currentThread().getName() + ": completed work.");

    }


    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread( () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": completed work.");
        });

        Thread t2 = new Thread( () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": completed work.");
        });

        Thread t3 = new Thread( () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": completed work.");
        });

        Thread t4 = new Thread( () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": completed work.");
        });

        Thread t5 = new Thread( () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": completed work.");
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t1.join();

        for (int i = 0; i < 10; i++) {
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + ": completed work.");
        }
    }
}
