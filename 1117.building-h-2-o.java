import java.util.concurrent.Semaphore;

/*
 * @lc app=leetcode id=1117 lang=java
 *
 * [1117] Building H2O
 */

// @lc code=start
class H2O {

    Semaphore h = new Semaphore(2);
    Semaphore o = new Semaphore(0);

    public H2O() {
        
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		h.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        o.release();
        
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
        h.release(2);
    }
}
// @lc code=end

