import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;

/*
 * @lc app=leetcode id=1226 lang=java
 *
 * [1226] The Dining Philosophers
 */

// @lc code=start
class DiningPhilosophers {

    Phaser root = new Phaser();
    volatile Phaser[] phasers = new Phaser[5];
    volatile Semaphore[] forks = new Semaphore[5];

    public DiningPhilosophers() {
        for (int i = 0; i < phasers.length; i++) {
            phasers[i] = new Phaser(root, 1);
            forks[i] = new Semaphore(1);
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        if (phasers[philosopher].getArrivedParties() == 1) {
            phasers[philosopher].arriveAndAwaitAdvance();
        } else {
            phasers[philosopher].arrive();
        }
        if (philosopher % 2 == 0) {
            forks[philosopher].acquire();
            pickLeftFork.run();
            forks[(philosopher+1) % 5].acquire();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            forks[philosopher].release();
            putRightFork.run();
            forks[(philosopher+1) % 5].release();
        } else {
            forks[(philosopher+1) % 5].acquire();
            pickLeftFork.run();
            forks[philosopher].acquire();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            forks[(philosopher+1) % 5].release();
            putRightFork.run();
            forks[philosopher].release();
        }

    }
}
// @lc code=end