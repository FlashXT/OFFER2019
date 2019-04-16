package JAVA.JUC.J01_createThread;

/******************************************************************
 * 创建线程方法一：
 *      ①将一个类声明为Thread的子类;
 *      ②重写子类的run()方法;
 *      ③然后创建子类的实例;
 *      ④调用start()方法启动线程;
 ******************************************************************/
class MyThread extends Thread{

    public MyThread(){}
    public MyThread(String name){
        super(name);
    }
    public void run(){
        System.out.println(sum(100));
    }
    public int sum(int n){
        int res = 0;
        for(int i = 1;i<= n;i++)
            res+=i;
        return res;
    }
}

/*********************************************************************
 * 创建线程方法二：
 *      ①一个类实现类Runnable接口;
 *      ②该类实现了Runnable接口的run()方法;
 *      ③然后创建子类的实例;
 *      ④将该类实例作为参数，创建Thread类的实例;
 *      ⑤调用start()方法启动线程;
 *
 *
 *********************************************************************/
class MyThread2 implements Runnable{
    public void run(){
        System.out.println(sum(100));
    }
    public int sum(int n){
        int res = 0;
        for(int i = 1;i<= n;i++)
            res+=i;
        return res;
    }
}

public class createThread {
    public static void main(String [] args){
        //创建方法一
        MyThread t1 = new MyThread("t1");
        t1.start();
        //创建方法二
        MyThread2 mt2 = new MyThread2();
        Thread t2 = new Thread(mt2);
        t2.start();
    }

}
