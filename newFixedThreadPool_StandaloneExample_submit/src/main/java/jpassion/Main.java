package jpassion;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    private static final int NUMBER_THREADS = 3;
    
    // newFixedThreadPool() Creates a thread pool 
    // that reuses a fixed number of threads operating 
    // off a shared unbounded queue.
    ExecutorService executorService = 
            Executors.newFixedThreadPool(NUMBER_THREADS);

    public void startSubmittingTasks() throws IOException {
        int i = 0;
        Future future;
        while (!executorService.isShutdown() && i < 10) {
            future = executorService.submit(new MyTask(i));
            //executorService.execute(new MyRunnableTask(i++));

            // Just shows how to use Future object to detect if the task has been done or not
            String doneStatus = future.isDone() ? "Yes it is done" : "No it is not done";
            System.out.println("Task " + i + " is done? " + doneStatus);
            i++;
        }

        // Initiates an orderly shutdown in which previously submitted 
        // tasks are executed, but no new tasks will be accepted. Invocation 
        // has no additional effect if already shut down.
        executorService.shutdown();
    }

    public static void main(String argv[]) throws Exception {
        new Main().startSubmittingTasks();
    }
}
