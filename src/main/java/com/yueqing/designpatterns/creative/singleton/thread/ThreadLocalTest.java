package com.yueqing.designpatterns.creative.singleton.thread;

/**
 * @author dingliming
 * @date 2022/7/19
 */
public class ThreadLocalTest {

    /**
     * 线程内共享
     */
    private static ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> "no value");

    /**
     * 父子线程内共享
     */
    private static final InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {

        threadLocal.set(Thread.currentThread().getName());

        inheritableThreadLocal.set(Thread.currentThread().getName());

        test();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                test();
            }
        };
        thread1.start();

        //及时移除，避免oom 及 内存泄露
        threadLocal.remove();
        inheritableThreadLocal.remove();
    }

    private static void test() {
        System.out.println(threadLocal.get());
        System.out.println(inheritableThreadLocal.get());
    }

}
