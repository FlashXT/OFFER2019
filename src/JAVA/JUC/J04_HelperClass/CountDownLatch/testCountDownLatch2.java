package JAVA.JUC.J04_HelperClass.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/****************************************************************************
 * java.util.concurrent.CountDownLatch 是一个并发构造，它允许一个或多个线程等待一
 * 系列指定操作完成后再执行。CountDownLatch 以一个给定的数量初始化。countDown()每被调
 * 用一次，这一数量就减一。通过调用 await() 方法之一，线程可以阻塞等待这一数量到达零。
 ****************************************************************************/
public class testCountDownLatch2 {

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);
        new Thread(){
            public void run() {
                try {
                    System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();

        new Thread(){
            public void run() {
                try {
                    System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();

        try {
            System.out.println("等待2个子线程执行完毕...");
            latch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}