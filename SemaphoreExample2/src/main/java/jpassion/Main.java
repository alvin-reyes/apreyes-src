package jpassion;

import java.util.concurrent.Semaphore;

class Main {

    public static void main(String[] args) {
        final int N = 3;

        System.out.println("Busy waiting...");

        // Create a semaphore
        Semaphore sem = new Semaphore(
                N, // Number of permits (resources)
                true); // fair - true if this semaphore will 
                       //guarantee first-in first-out granting 
                       //of permits under contention

        // Have N+1 number of users to compete for N 
        // number of resources.
        MyTask[] p = new MyTask[N + 1];

        for (int i = 0; i < N + 1; i++) {
            p[i] = new MyTask(i, sem);
            p[i].start();
        }
    }
}
