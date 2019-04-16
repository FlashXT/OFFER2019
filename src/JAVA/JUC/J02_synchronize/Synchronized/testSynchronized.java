package JAVA.JUC.J02_synchronize.Synchronized;

/***************************************************************************************
 * 并发：同一个对象，多个线程，同时操作
 * 线程同步：线程同步就是一种等待机制，多个需要同时访问此对象的线程进入这个对象的等待池队列，按顺序访问；
 * 线程同步的两个条件：等待池队列，锁机制；
 * 锁机制：
 *  ①一个线程持有锁会导致其他所有需要此锁的贤臣挂起；
 *  ②在多线程的竞争下，加锁、释放锁会导致比较多的上下文切换和调度演示，引起性能问题；
 *  ③如果一个优先级高的线程等待一个优先级低的线程释放锁会导致优先级倒置，引起性能问题；
 *
 *                                synchronized锁对象
 ***************************************************************************************/

//synchronized锁方法
public class testSynchronized implements Runnable{
    int num = 10;
    public synchronized void run(){
        while(num > 0 ){
            try{
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName()+":"+this.num--);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }

    }
    public static void main(String [] args){
        testSynchronized ts = new testSynchronized();
        int i =0;
        while(i < 10){
            new Thread(ts).start();
            i++;
        }

    }
}