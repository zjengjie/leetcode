
/*
 * @lc app=leetcode id=1115 lang=java
 *
 * [1115] Print FooBar Alternately
 */

// @lc code=start
class FooBar {
    private int n;
    volatile private boolean foo = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
        	while(!foo)
                Thread.yield();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            foo = false;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while(foo)
                Thread.yield();
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            foo = true;
        }
    }
}
// @lc code=end

