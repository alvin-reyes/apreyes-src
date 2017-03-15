package jpassion;

class MyTask implements Runnable {

    private int i;

    MyTask(int i) {
        this.i = i;
    }

    public void run() {
        System.out.println("Task " + i + " is running");
    }
}
