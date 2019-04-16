package JAVA.JUC.J06_Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**********************************************************************************
 * java.util.concurrent.locks.Lock 是一个类似于 synchronized 块的线程同步机制。但
 * 是 Lock 比 synchronized 块更加灵活、精细。
 *  Lock 是一个接口，它的实现类:ReentrantLock。
 *  Lock 和synchronized同步块的不同点：
 *      ①synchronized 代码块不能够保证进入访问等待的线程的先后顺序。
 *      ②你不能够传递任何参数给一个synchronized 代码块的入口。因此，对于 synchronized
 *        代码块的访问等待设置超时时间是不可能的事情。
 *      ③synchronized 块必须被完整地包含在单个方法里。而一个 Lock 对象可以把它的 lock()
 *        和 unlock() 方法的调用放在不同的方法里。
 *
 *Lock 接口具有以下主要方法：
 *lock()：将 Lock 实例锁定。如果该 Lock 实例已被锁定，调用 lock() 方法的线程将会阻塞，直到
 *        Lock 实例解锁。
 *lockInterruptibly()：当通过这个方法去获取锁时，如果其他线程正在等待获取锁，则这个线程能够响
 *        应中断，即中断线程的等待状态。也就使说，当两个线程同时通过lock.lockInterruptibly()
 *        想获取某个锁时，假若此时线程A获取到了锁，而线程B只有等待，那么对线程B调用
 *        threadB.interrupt()方法能够中断线程B的等待过程。
 *tryLock()：该方法试图立即锁定 Lock 实例。如果锁定成功，它将返回 true，如果 Lock 实例已被
 *        锁定该方法返回 false。这一方法永不阻塞。
 *tryLock(long timeout, TimeUnit timeUnit)：类似于 tryLock() 方法，它在放弃锁定 Lock
 *        之前等待一个给定的超时时间。
 *unlock()：该方法对 Lock 实例解锁。一个 Lock 实现将只允许锁定了该对象的线程来调用此方法。其
 *        他(没有锁定该 Lock 对象的线程)线程对 unlock() 方法的调用将会抛一个未检查异常
 *        (RuntimeException)。
 *
 *https://www.cnblogs.com/aspirant/p/6930436.html
 ************************************************************************************/
public class testLock {
    public static void main(String [] args) throws InterruptedException {
//      testLock();
        testlockInterruptibly();
    }

    public static void testLock(){
        Lock lock = new ReentrantLock();
        lock.lock();
        //操作
        lock.unlock();
        //首先创建了一个 Lock 对象。之后调用了它的 lock() 方法。这时候这个 lock 实例就被锁住啦。
        //任何其他再过来调用lock()方法的线程将会被阻塞住，直到锁定 lock 实例的线程调用了unlock()
        // 方法。最后unlock()被调用了，lock 对象解锁了，其他线程可以对它进行锁定了。
    }
    public static void testlockInterruptibly() throws InterruptedException {
        final Lock lock=new ReentrantLock();
        lock.lock();
        Thread.sleep(1000);
        Thread t1=new Thread(new Runnable(){
            @Override
            public void run() {
//                lock.lock();
	        	try {
	        	    //①中断锁
					lock.lockInterruptibly();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                System.out.println(Thread.currentThread().getName()+" interrupted.");
            }
        });
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
        Thread.sleep(1000);

    }



}
