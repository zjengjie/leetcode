import java.util.function.IntConsumer;

/*
 * @lc app=leetcode id=1116 lang=java
 *
 * [1116] Print Zero Even Odd
 */

// @lc code=start
class ZeroEvenOdd {
    private int n;
    private volatile int count = 1;
    private volatile int f = 0;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while(count <= n) {
            if (f != 0)
                Thread.yield();
            else {
                printNumber.accept(0);
                f = count % 2 + 1;
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while(count <= n) {
            if (f != 1)
                Thread.yield();
            else {
                printNumber.accept(count++);
                f = 0;
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while(count <= n) {
            if (f != 2)
                Thread.yield();
            else {
                printNumber.accept(count++);
                f = 0;
            }
        }
    }
}
// @lc code=end

