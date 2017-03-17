package jpassion;

/**
 *  Use resources from a pool and return them at random times
 **/
public class ResourceUserTask implements Runnable {

    private ResourcePoolManagedBySemaphore pool;
    private int threadId;
    private int runCount;
    private long hold;
    private long pause;

    /**
     *  Constructor
     *
     * @param pool The pool to get the resource from
     * @param threadId The id number of this thread
     * @param runCount The number of times to run the test loop
     * @param hold How long to hold the resource before releasing it
     * @param pause How long to wait before trying to re-aquire the resource
     **/
    public ResourceUserTask(ResourcePoolManagedBySemaphore pool, int threadId, int runCount,
            long hold, long pause) {
        this.pool = pool;
        this.threadId = threadId;
        this.runCount = runCount;
        this.hold = hold;
        this.pause = pause;
    }

    /**
     *  Request a resource from the pool and
     *  return them after a random time period
     **/
    public void run() {
        for (int i = 0; i < runCount; i++) {
            try {
                /*  Get the resource from the pool  */
                System.out.println("[" + threadId + "] trying to get resource");
                Integer resource = pool.getResource();
                System.out.println("[" + threadId + "] aquired resource");

                Thread.sleep(hold);
                System.out.println("[" + threadId + "] releasing resource");
                pool.putResource(resource);
                Thread.sleep(pause);
            } catch (InterruptedException ie) {
                //  Silently ignore
            }
        }
    }

}