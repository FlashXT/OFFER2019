package JUC.J04_HelperClass.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/****************************************************************************
 * java.util.concurrent.CountDownLatch 是一个并发构造，它允许一个或多个线程等待一
 * 系列指定操作完成后再执行。CountDownLatch 以一个给定的数量初始化。countDown()每被调
 * 用一次，这一数量就减一。通过调用 await() 方法之一，线程可以阻塞等待这一数量到达零。
 ****************************************************************************/
public class testCountDownLatch {
    public static void main(String [] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(6);

        Waiter      waiter      = new Waiter(latch);
        Decrementer decrementer = new Decrementer(latch);
        new Thread(waiter).start();
        new Thread(decrementer).start();
        Thread.sleep(4000);

    }
}
class Waiter implements Runnable{

    CountDownLatch latch = null;

    public Waiter(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Waiter Released");
    }
}
class Decrementer implements Runnable {

    CountDownLatch latch = null;

    public Decrementer(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {

        try {
            while(this.latch.getCount()>0){
                Thread.sleep(1000);
                this.latch.countDown();
                System.out.println(this.latch.getCount());
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
