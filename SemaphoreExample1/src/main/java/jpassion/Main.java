package jpassion;

import java.util.concurrent.*;

public class Main {

    private static final int NUMBER_OF_RESOURCES = 2;
    private static final int NUMBER_OF_RESOURCE_USERS = 3;
    
    public static void main(String[] args) {

        ResourcePoolManagedBySemaphore pool = 
                new ResourcePoolManagedBySemaphore(NUMBER_OF_RESOURCES);

        ExecutorService executorService = 
                Executors.newFixedThreadPool(NUMBER_OF_RESOURCE_USERS);


        ResourceUserTask r1 = new ResourceUserTask(
                pool, // Resource pool
                1, // Thread id
                5, // Run count
                400, // Hold duration
                500);   // Pause duration
        ResourceUserTask r2 = new ResourceUserTask(pool, 2, 5, 800, 500);
        ResourceUserTask r3 = new ResourceUserTask(pool, 3, 5, 1200, 500);

        executorService.execute(r1);
        executorService.execute(r2);
        executorService.execute(r3);

        executorService.shutdown();
    }
}