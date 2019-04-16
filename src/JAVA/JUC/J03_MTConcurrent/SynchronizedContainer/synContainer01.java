package JAVA.JUC.J03_MTConcurrent.SynchronizedContainer;

import java.util.ArrayList;
import java.util.Vector;

/************************************************************************************
 * 同步容器：https://www.cnblogs.com/dolphin0520/p/3933404.html
 * 在Java中，同步容器主要包括2类：
 * 　1）Vector、Stack、HashTable；
 * 　　 Vector实现了List接口，Vector实际上就是一个数组，和ArrayList类似，但是Vector中的方法
 *        都是synchronized方法，即进行了同步措施。
 *     Stack也是一个同步容器，它的方法也用synchronized进行了同步，它实际上是继承于Vector类。
 * 　　 HashTable实现了Map接口，它和HashMap很相似，但是HashTable进行了同步处理，而HashMap没有。
 *   2）Collections类中提供的静态工厂方法创建的类。
 * 　　 Collections类是一个工具提供类，注意，它和Collection不同，Collection是一个顶层的接口。
 *      在Collections类中提供了大量的方法，比如对集合或者容器进行排序、查找等操作。最重要的是，
 *      在它里面提供了几个静态工厂方法来创建同步容器类；
 *同步容器的缺陷：
 *   1)从同步容器的具体实现源码可知，同步容器中的方法采用了synchronized进行了同步，那么很显然，这必
 *     然会影响到执行性能;
 *   2)同步容器就一定是真正地完全线程安全吗？不一定。
 *   3)ConcurrentModificationException异常:
 * 　　 在对Vector等容器并发地进行迭代修改时，会报ConcurrentModificationException异常,但是在并
 *      发容器中不会出现这个问题。
 *************************************************************************************/
public class synContainer01 {
    public static void main(String[] args){
        testsyncontainer3();
    }
    //测试同步容器的效率
    public static void testsyncontainer(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        Vector<Integer> vector = new Vector<Integer>();
        for(int i=0;i<10;i++){
            Thread thread1 = new Thread(){
                public void run(){
                    long start = System.currentTimeMillis();
                    for(int i=0;i<100000;i++)
                        list.add(i);
                    long end = System.currentTimeMillis();
                    System.out.println("ArrayList进行100000次插入操作耗时："+(end-start)+"ms");
                };
            };
            thread1.start();
        }
        for(int i=0;i<10;i++){
            Thread thread2 = new Thread(){
                public void run(){
                    long start = System.currentTimeMillis();
                    for(int i=0;i<100000;i++)
                        vector.add(i);
                    long end = System.currentTimeMillis();
                    System.out.println("Vector进行100000次插入操作耗时："+(end-start)+"ms");
                };
            };
            thread2.start();
        }

    }
    //测试同步容器的安全性
    public static void testsyncontainer2() {
        Vector<Integer> vector = new Vector<Integer>();
        for (int i = 0; i < 3; i++)
            vector.add(i);
        int k = 0;
        while (k++ < 5){
            new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ",remove:" + vector.remove(i));
                }
            }).start();
            new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) {
                    //获取到vecotr.size()之后会等待一段时间；若此时另一个线程执行了
                    // remove方法，则vector.size()改变，此时再执行get方法就会出错；
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ",get:" + vector.get(i));

                }
            }).start();
        }
    }
    //同步容器的安全
    public static void testsyncontainer3() {
        Vector<Integer> vector = new Vector<Integer>();
        for (int i = 0; i < 10; i++)
            vector.add(i);
        int k = 0;
        while (k++ < 5){
            new Thread(() -> {
                synchronized (vector){
                    if(vector.size()==0) {
                        System.out.println(Thread.currentThread().getName()+",remove:"+"size = 0");
                        return ;
                    }
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int i = 0; i < vector.size(); i++) {
                        System.out.println(Thread.currentThread().getName() + ",remove:" + vector.remove(i));
                    }
                }
            }).start();
            new Thread(() -> {

                synchronized (vector) {
                    if(vector.size()==0) {
                        System.out.println(Thread.currentThread().getName()+",get:"+"size = 0");
                        return ;
                    }
                    for (int i = 0; i < vector.size(); i++) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + ",get:" + vector.get(i));
                    }
                }
            }).start();

        }
    }
}
