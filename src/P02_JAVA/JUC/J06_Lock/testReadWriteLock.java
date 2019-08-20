package P02_JAVA.JUC.J06_Lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/***************************************************************************
 * java.util.concurrent.locks.ReadWriteLock 读写锁是一种先进的线程锁机制。它能
 * 够允许多个线程在同一时间对某特定资源进行读取，但同一时间内只能有一个线程对其进行写入。
 * 读写锁的理念在于多个线程能够对一个共享资源进行读取，而不会导致并发问题。并发问题的发
 * 生场景在于对一个共享资源的读和写操作的同时进行，或者多个写操作并发进行。
 * ReadWriteLock 锁规则:
 *  一个线程在对受保护资源在读或者写之前对 ReadWriteLock 锁定的规则如下：
 *     读锁：如果没有任何写操作线程锁定 ReadWriteLock，并且没有任何写操作线程要求一个
 *          写锁(但还没有获得该锁)。因此，可以有多个读操作线程对该锁进行锁定。
 *     写锁：如果没有任何读操作或者写操作。因此，在写操作的时候，只能有一个线程对该锁进
 *          行锁定。
 *
 * ReadWriteLock 实现:
 *     ReadWriteLock 是个接口，它的实现类:ReentrantReadWriteLock
 *
 ***************************************************************************/
public class testReadWriteLock {

    public static void main(String []args) {
        testRWLock();
    }

    public static void testRWLock() {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        int i =0,j = 0;
        while(i++ < 3){
            j = 0;
            while(j++ < 3)
                new Thread(()->
                {
                    readLock(Thread.currentThread().getName(),readWriteLock);
                }
                ).start();
            new Thread(()->
            {
                writeLock(Thread.currentThread().getName(),readWriteLock);
            }
            ).start();
        }
    }
    public static void writeLock(String name,ReadWriteLock rwLock){
        rwLock.writeLock().lock();
        System.out.println(name+":writing......");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+":writing over.");
        rwLock.writeLock().unlock();

    }
    public static void readLock(String name,ReadWriteLock rwLock){
        rwLock.readLock().lock();
        System.out.println(name+":reading......");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+":reading over.");
        rwLock.readLock().unlock();

    }
}
