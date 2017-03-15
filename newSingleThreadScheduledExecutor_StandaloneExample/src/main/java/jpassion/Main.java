package jpassion;


/*
License for Java 1.5 'Tiger': A Developer's Notebook
(O'Reilly) example package

Java 1.5 'Tiger': A Developer's Notebook (O'Reilly) 
by Brett McLaughlin and David Flanagan.
ISBN: 0-596-00738-8

You can use the examples and the source code any way you want, but
please include a reference to where it comes from if you use it in
your own products or services. Also note that this software is
provided by the author "as is", with no expressed or implied warranties. 
In no event shall the author be liable for any direct or indirect
damages arising in any way out of the use of this software.
 */
import static java.util.concurrent.TimeUnit.SECONDS;

import java.io.PrintStream;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

public class Main {

    public static void main(String[] args) {
        // newSingleThreadScheduledExecutor() creates a single-threaded 
        // executor that can schedule commands to run after a given delay, 
        // or to execute periodically.
        ScheduledExecutorService scheduledExecutedService =
                Executors.newSingleThreadScheduledExecutor();

        // Run the TimerPrinterTask every 3 seconds with 1 second initial delay
        final ScheduledFuture<?> timeHandle =
                scheduledExecutedService.scheduleAtFixedRate(
                new TimePrinterTask(System.out), // Task to execute
                1, // Initial delay
                3, // the period between successive executions
                SECONDS); //  the time unit

        // Schedule the event - cancel the timeHandle task in 40 seconds
        scheduledExecutedService.schedule(new Runnable() {// This is inner class
            public void run() {
                timeHandle.cancel(
                        false); // mayInterruptIfRunning - true if the thread 
                                // executing this task should be interrupted; 
                                // otherwise, in-progress tasks are allowed to complete
            }
        }, 40 * 1, SECONDS);

    }
}
