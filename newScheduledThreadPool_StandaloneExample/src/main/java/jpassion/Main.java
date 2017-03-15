package jpassion;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

public class Main {

    private static final int POOL_SIZE = 3;

    public static void main(String[] args) {

        // newScheduledThreadPool(POOL_SIZE) creates a thread pool 
        // that can schedule commands to run after a given delay, or 
        // to execute periodically
        ScheduledExecutorService scheduledExecutedService =
                Executors.newScheduledThreadPool(POOL_SIZE);

        // Run the TimerPrinterTask every 3 seconds with 1 second initial delay
        final ScheduledFuture<?> timeHandle1 =
                scheduledExecutedService.scheduleAtFixedRate(
                new TimePrinterTask1(System.out), // Task to execute
                1, // Initial delay
                3, // the period between successive executions
                SECONDS); //  the time unit

        // Run the TimerPrinterTask every 5 seconds with 3 second initial delay
        final ScheduledFuture<?> timeHandle2 =
                scheduledExecutedService.scheduleAtFixedRate(
                new TimerPrinterTask2(System.out), // Task to execute
                3, // Initial delay
                5, // the period between successive executions
                SECONDS); //  the time unit               

        // Schedule the event - cancel the timeHandle task in 40 seconds
        scheduledExecutedService.schedule(new Runnable() {// This is inner class

            public void run() {
                timeHandle1.cancel(
                        false); // mayInterruptIfRunning - true if the thread 
                // executing this task should be interrupted; 
                // otherwise, in-progress tasks are allowed to complete
            }
        }, 40 * 1, SECONDS);

        // Schedule the event - cancel the timeHandle task in 40 seconds
        scheduledExecutedService.schedule(new Runnable() {// This is inner class

            public void run() {
                timeHandle2.cancel(
                        false); // mayInterruptIfRunning - true if the thread 
                // executing this task should be interrupted; 
                // otherwise, in-progress tasks are allowed to complete
            }
        }, 40 * 1, SECONDS);

    }
}
