package jpassion;

import java.util.concurrent.*;

/**
 *  Use a Semaphore to control the usage of a pool of resources.  If a
 *  consumer requests a resource, when all are being used, the consumer
 *  will block until a resource is returned.
 **/
public class ResourcePoolManagedBySemaphore {
  private int poolSize;
  private Semaphore semaphore;
  private Integer[] resources;
  private boolean[] used;

  /**
   *  Constructor
   *
   * @param poolSize Size of fixed pool of resources
   **/
  public ResourcePoolManagedBySemaphore(int poolSize) {
      
    this.poolSize = poolSize;

    semaphore = new Semaphore(poolSize);

    // Array to keep track of the resource usage for demo purpose
    used = new boolean[poolSize];
    
    // These are our resources
    resources = new Integer[poolSize];
    for (int i = 0; i < poolSize; i++)
      resources[i] = new Integer(i);
  }

  /**
   *  Get a resource.  If all are currently being used this will block
   *  until one is returned to the resource pool.  
   *
   * @return The resource to use
   **/
  public Integer getResource() {
    try {
      semaphore.acquire();
    } catch (InterruptedException ie) {
      // Ignore
    }

    // Manage the resource
    for (int i = 0; i < poolSize; i++) {
      if (used[i] == false) {
        used[i] = true;
        return resources[i];
      }
    }

    return null;
  }

  /**
   *  Return a resource to the pool
   *
   * @param resource The resource being returned to the pool
   **/
  public void putResource(Integer resource) {
    /*  Note use of auto-unboxing  */
    used[resource] = false;
    semaphore.release();
  }
}