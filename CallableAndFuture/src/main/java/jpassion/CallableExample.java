package jpassion;

import java.util.concurrent.*;

/**
 *  A simple implementation of the Callable interface that can return a value
 *  to the thread that started it
 **/
public class CallableExample implements Callable<String> {
    /**
     *  The entry point called when this object is invoked as a new thread
     *  of execution
     *
     * @returns A String as a simple result
     **/
    public String call() {
        System.out.println("Starting call() method in second thread (callee)");
        
        try {
            Thread.sleep(500);
        } catch (InterruptedException ie) {
            // Ignore
        }
        
        System.out.println("Completed call() method in second thread (callee)");
        return "Me Called thread is successfully finished!";
    }
}