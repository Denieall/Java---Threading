package com.company;

public class Main {

    static Pause p = new Pause();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            p.wait5();
            System.out.println("Done");
        });

        t1.start();

        System.out.println("Hello World");

    }


}

class Pause {

    public void wait5() {
        synchronized (this) {
            try {
                wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
