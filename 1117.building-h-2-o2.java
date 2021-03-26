import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/*
 * @lc app=leetcode id=1117 lang=java
 *
 * [1117] Building H2O
 */

// @lc code=start
class H2O {

    class Sync extends AbstractQueuedSynchronizer {
        private AtomicInteger myState = new AtomicInteger();// 因为原来的state没提供addAndGet方法

        @Override
        protected int tryAcquireShared(int arg) {
            int flag = arg == 1 ? 2 : 4;// arg == 1时为H，arg == 4时为O，
            int i = myState.get();// i & 3为H的标记位，但最多只能加到2，i & 4为O的标记位
            if ((i & flag) != flag && myState.compareAndSet(i, i + arg)) {
                return ((i + arg) & 0b0111) == 6 ? 0 : 1;// 为6则表示坑位满了，故返回0
            }
            return -1;
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            // 记录完成当前工作，因为此处无竞争，故不必用cas，直接加即可
            if (myState.addAndGet(arg) == 0b110110) {
                // 这两行代码之间，严格保证此时打印出的是完整的水分子
                myState.set(0);// 如果大家都完成了，则重置并唤醒等待者
                return true;
            }
            return false;
        }
    }

    public H2O() {
        
    }

    private Sync sync = new Sync();

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        sync.acquireShared(1);
        releaseHydrogen.run();
        sync.releaseShared(0b00001000);

    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        sync.acquireShared(4);
        releaseOxygen.run();
        sync.releaseShared(0b00100000);

    }
}
// @lc code=end

