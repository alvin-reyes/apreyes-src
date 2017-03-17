package jpassion;

import java.util.concurrent.Semaphore;
import java.util.Random;

class MyTask extends Thread {

    private static final Random rand = new Random();
    private int id;
    private Semaphore sem;

    public MyTask(int i, Semaphore s) {
        id = i;
        sem = s;
    }

    private void doSomething() {
        try {
            sleep(rand.nextInt(500));
        } catch (InterruptedException e) {
        }
    }

    private void doNonCrtiticalworkThatDontRequireResource() {
        System.out.println("MyTask Thread " + id + " is NON critical");
        doSomething();
    }

    private void doCriticalWorkThatRequiresResource() {
        System.out.println("MyTask Thread " + id + " entering critical section");
        doSomething();
        System.out.println("MyTask Thread " + id + " leaving critical section");
    }

    public void run() {
        for (int i = 0; i < 2; ++i) {
            doNonCrtiticalworkThatDontRequireResource();
            try {
                sem.acquire();
            } catch (InterruptedException e) {
                // ...
            }
            doCriticalWorkThatRequiresResource();
            sem.release();
        }
    }

}
