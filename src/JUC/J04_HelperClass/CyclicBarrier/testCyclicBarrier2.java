package JUC.J04_HelperClass.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/***********************************************************************************
 *   java.util.concurrent.CyclicBarrier 类是一种同步机制，它能够对处理一些算法
 * 的线程实现同步。换句话讲，它就是一个所有线程必须等待的一个栅栏，直到所有线程都到达
 * 这里，然后所有线程才可以继续做其他事情。
 * thread1-------------- | -----------------------|--------------->
 *                 CyclicBarrier1           CyclicBarrier1
 * thread2-------------- | -----------------------|--------------->
 *              两个线程在栅栏旁等待对方。
 *   通过调用 CyclicBarrier 对象的 await() 方法，两个线程可以实现互相等待。一旦N个
 * 线程在等待 CyclicBarrier 达成，所有线程将被释放掉去继续运行;
 *
 * CyclicBarrier类位于java.util.concurrent包下，CyclicBarrier提供2个构造器：
 *
 *          public CyclicBarrier(int parties, Runnable barrierAction) {};
 *          public CyclicBarrier(int parties) {};
 *
 *    参数parties指让多少个线程或者任务等待至barrier状态；参数barrierAction为当这
 * 些线程都达到barrier状态时，从这些线程中先择一个去执行barrierAction。
 * CyclicBarrier中最重要的方法就是await方法，它有2个重载版本：
 *      public int await() throws InterruptedException, BrokenBarrierException { };
 *      public int await(long timeout, TimeUnit unit)throws InterruptedException,
 *                                      BrokenBarrierException,TimeoutException { };
 *    第一个版本比较常用，用来挂起当前线程，直至所有线程都到达barrier状态再同时执行后续任务；
 *    第二个版本是让这些线程等待至一定的时间，如果还有线程没有到达barrier状态就直接让到达barrier
 * 的线程执行后续任务。
 ***********************************************************************************/
public class testCyclicBarrier2 {
    public static void main(String [] args) throws InterruptedException {
        int n = 4;
        CyclicBarrier barrier = new CyclicBarrier(n, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"开始执行");
            }
        });
        for(int i=0;i<n;i++){
            if(i < n-1){
                new Writer2(barrier).start();
            }
            else{
                Thread.sleep(5000);
                new Writer2(barrier).start();
            }


        }

    }
}

class Writer2 extends Thread{
    private CyclicBarrier cyclicBarrier;
    public Writer2(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"正在写入数据...");
        try {
            Thread.sleep(1000);      //以睡眠来模拟写入数据操作

            System.out.println(Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入完毕");
//            cyclicBarrier.await();
            cyclicBarrier.await(3000, TimeUnit.MILLISECONDS);

        }catch(BrokenBarrierException | InterruptedException|TimeoutException e){
            e.printStackTrace();
        }
        System.out.println("所有线程写入完毕，继续处理其他任务...");
    }
}
