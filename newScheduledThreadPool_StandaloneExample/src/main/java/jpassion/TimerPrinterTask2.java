package jpassion;

import java.io.PrintStream;
import java.util.Date;

class TimerPrinterTask2 implements Runnable {

    private PrintStream out;

    public TimerPrinterTask2(PrintStream out) {
        this.out = out;
    }

    public void run() {
        out.printf("From TimePrinterTask2: Current time: %tr%n", new Date());
    }
}