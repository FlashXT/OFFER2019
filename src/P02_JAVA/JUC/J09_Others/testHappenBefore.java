package P02_JAVA.JUC.J09_Others;

/******************************************************************************
 *                            Happen-Before(指令重排)
 * Happen-Before原则八大原则：
 *  单线程happen-before原则：在同一个线程中，书写在前面的操作happen-before后面的操作。
 *  锁的happen-before原则：同一个锁的unlock操作happen-before此锁的lock操作。
 *  volatile的happen-before原则：对一个volatile变量的写操作happen-before对此变量的任意操作(当然也包括写操作了)。
 *  happen-before的传递性原则：如果A操作 happen-before B操作，B操作happen-before C操作，那么A操作happen-before C操作。
 *  线程启动的happen-before原则：同一个线程的start方法happen-before此线程的其它方法。
 *  线程中断的happen-before原则：对线程interrupt方法的调用happen-before被中断线程的检测到中断发送的代码。
 *  线程终结的happen-before原则：线程中的所有操作都happen-before线程的终止检测。
 *  对象创建的happen-before原则：一个对象的初始化完成先于他的finalize方法调用。
 *
 * https://blog.csdn.net/hanchao5272/article/details/79575491
 ******************************************************************************/
public class testHappenBefore {
    //变量1
    private  static int a = 0;
    //变量2
    private static boolean flag = false;
    public static void main(String [] args) throws InterruptedException {
        for(int i=0;i<10;i++) {
            a = 0;
            flag = false;

            //线程1 更改数据
            Thread t1 = new Thread(()->{
                a = 1;
                flag = true;
            }) ;
            //线程2 读取数据
            Thread t2 = new Thread(()->{
                if(flag) {
                    a *=1;
                }
                //指令重排
                if(a == 0) {
                    System.out.println("happen before a->"+a);
                }
            }) ;

            t1.start();
            t2.start();

            //合并线程
            t1.join();
            t2.join();
        }

    }
}
