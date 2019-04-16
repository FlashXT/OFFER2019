package JUC.J06_Lock;

public class MyReetrantLock {
    public  static void main(String []args){
        mReentrantLock mrLock = new mReentrantLock();
        new Thread(()->{
            mrLock.lock();
                System.out.println("获得外层mLock。。。");
                mrLock.lock();
                    System.out.println("获得内层mLock。。。");
                mrLock.unlock();
            mrLock.unlock();
        }).start();

    }

}

class mReentrantLock{
    private boolean isLocked = false;
    //记录获得锁的线程
    private Thread lockBy = null;
    //记录获得锁的线程的重入次数
    private int count = 0;
    public mReentrantLock(){}
    public synchronized void lock() {
        //获取当前线程
        Thread currentThread = Thread.currentThread();
        //已经有线程获得锁，并且获得锁的线程不是当前线程，那么不满足获得锁，线程需要等待
        while (isLocked && currentThread != lockBy)
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        //没有线程获得锁，或者获得锁的线程就是当前线程
        isLocked = true;
        lockBy = currentThread;
        //记录当前线程的重入次数
        count++;
    }

    public synchronized void unlock() {
        //释放锁时，只有当获得锁的线程和当前线程是同一线程时才是正确的
        if (lockBy == Thread.currentThread()) {
            //线程重入次数减一
            count--;
            //只有当count变为0也就是所有获取锁的地方都已经释放了，
            // 才能够真正释放锁，修改标志位，唤醒其他线程
            if (count == 0) {
                notify();
                isLocked = false;
            }
        }
    }
}