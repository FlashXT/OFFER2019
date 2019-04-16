package JAVA.JUC.J08_AtomicType;

import java.util.concurrent.atomic.AtomicInteger;

public class testAtomicInteger {
    public static void main(String [] args){
        AtomicInteger aint = new AtomicInteger();
        AtomicInteger aint2 = new AtomicInteger(30);
        int a = aint.get();
        System.out.println(a);
        aint.set(100);
        System.out.println(aint.get());
        //交换 AtomicInteger 的值
        //通过 getAndSet() 方法来交换一个 AtomicInteger实例的值。
        //getAndSet() 方法将返回 AtomicInteger 当前的值，并将为
        // AtomicInteger 设置一个新值。
        int oldValue = aint.getAndSet(211);
        System.out.println(oldValue+" "+aint.get());

        //CAS, 比较并设置 AtomicInteger 的值
        //compareAndSet() 方法允许你对 AtomicInteger的当前值与一个期望值进
        //行比较，如果当前值等于期望值的话，将会对 AtomicInteger设定一个新值。
        //compareAndSet() 方法是原子性的，因此在同一时间之内有单个线程执行它。
        //因此 compareAndSet() 方法可被用于一些类似于锁的同步的简单实现。

        aint2 = new AtomicInteger(111);

        int expectedValue = 113;
        int newValue      = 112;

        boolean wasNewValueSet = aint2.compareAndSet(
                expectedValue, newValue);
        System.out.println(wasNewValueSet);
        System.out.println(aint2.get());
        System.out.println(aint2.getAndAdd(10));
        System.out.println(aint2.addAndGet(10));
        System.out.println(aint2.getAndIncrement());
        System.out.println(aint2.getAndDecrement());


    }
}
