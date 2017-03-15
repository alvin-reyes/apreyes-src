package jpassion;

import java.io.PrintStream;
import java.util.Date;

class TimePrinterTask1 implements Runnable {

    private PrintStream out;

    public TimePrinterTask1(PrintStream out) {
        this.out = out;
    }

    public void run() {
        out.printf("From TimePrinterTask1: Current time: %tr%n", new Date());
    }
}