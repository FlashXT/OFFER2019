package P02_JAVA.JUC.J08_AtomicType;

import java.util.concurrent.atomic.AtomicBoolean;

public class testAtomicBoolean {
    public static void main(String [] args){
        AtomicBoolean atomicBoolean = new AtomicBoolean();//默认false
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(true);
        boolean bool = atomicBoolean.get();
        System.out.println(bool);
        atomicBoolean.set(true);
        System.out.println(atomicBoolean.get());
        //交换 AtomicBoolean 的值
        //通过 getAndSet() 方法来交换一个 AtomicBoolean 实例的值。
        //getAndSet() 方法将返回 AtomicBoolean 当前的值，并将为
        // AtomicBoolean 设置一个新值。
        boolean oldValue = atomicBoolean.getAndSet(false);
        System.out.println(oldValue+" "+atomicBoolean.get());

        //CAS, 比较并设置 AtomicBoolean 的值
        //compareAndSet() 方法允许你对 AtomicBoolean 的当前值与一个期望值进
        //行比较，如果当前值等于期望值的话，将会对 AtomicBoolean 设定一个新值。
        //compareAndSet() 方法是原子性的，因此在同一时间之内有单个线程执行它。
        //因此 compareAndSet() 方法可被用于一些类似于锁的同步的简单实现。

        atomicBoolean = new AtomicBoolean(true);

        boolean expectedValue = true;
        boolean newValue      = false;

        boolean wasNewValueSet = atomicBoolean.compareAndSet(
                expectedValue, newValue);
        System.out.println(wasNewValueSet);
    }
}
