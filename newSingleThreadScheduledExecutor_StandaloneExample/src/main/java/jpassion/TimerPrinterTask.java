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

import java.io.PrintStream;
import java.util.Date;

class TimePrinterTask implements Runnable {

    private PrintStream out;

    public TimePrinterTask(PrintStream out) {
        this.out = out;
    }

    public void run() {
        out.printf("From TimePrinterTask: Current time: %tr%n", new Date());
    }
}