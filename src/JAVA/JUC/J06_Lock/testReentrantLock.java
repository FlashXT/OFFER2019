package JAVA.JUC.J06_Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class testReentrantLock {

    public static void main(String [] args){
//        testDeadLock();
        test2();

    }
    //死锁
    public static void testDeadLock(){
        //死锁,锁不能串行，用完就要释放
        Lock lock = new ReentrantLock();
        Lock lock2 = new ReentrantLock();
        new Thread(() -> {

            a(Thread.currentThread().getName(),lock,lock2);
        }).start();
        new Thread(() -> {

            b(Thread.currentThread().getName(),lock2,lock);
        }).start();
    }
    public static void a(String name,Lock lock,Lock lock2) {
        lock.lock();
        System.out.println(name+":a()方法获取到lock,执行到lock2处,等待获取lock2...");
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }


        lock2.lock();
        System.out.println(name+":获取到lock2，a()方法执行完成。");
        lock2.unlock();

        lock.unlock();



    }
    public static void b(String name,Lock lock2,Lock lock) {
        lock2.lock();
        System.out.println(name+":b()方法获取到lock2,执行到lock处,等待获取lock...");
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        lock.lock();
        System.out.println(name+":获取到lock，b()方法执行完成。");
        lock.unlock();


        lock2.unlock();


    }

    //②可重入锁
    public static void test2(){
        //②可重入锁：如果锁具备可重入性，则称作为可重入锁。像synchronized和
        // ReentrantLock都是可重入锁，可重入性在我看来实际上表明了锁的分配
        // 机制：基于线程的分配，而不是基于方法调用的分配。
        new Thread(() -> {

            a(Thread.currentThread().getName());
        }).start();
        new Thread(() -> {

            b(Thread.currentThread().getName());
        }).start();
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            c(Thread.currentThread().getName());
        }).start();

    }
    public static void a(String name) {
        synchronized (Class.class.getClass()) {
            synchronized (Class.class.getClass()) {
                System.out.println(name + ":a()->synchronized1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (Class.class.getClass()) {
                System.out.println(name + ":a()->synchronized2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void b(String name) {
        synchronized (Class.class.getClass()) {
            synchronized (Class.class.getClass()) {
                System.out.println(name + ":b()->synchronized1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (Class.class.getClass()) {
                System.out.println(name + ":b()->synchronized2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void c(String name) {
        //③公平锁（fair为true）
        Lock lock = new ReentrantLock(true);
        lock.lock();
        System.out.println(name + ":c()->获得外层lock...");
            lock.lock();
                System.out.println(name + ":c()->->获得内层lock...");
            lock.unlock();
            System.out.println(name + ":c()->->释放内层lock...");
        lock.unlock();
        System.out.println(name + ":c()->释放外层lock...");


    }
}
