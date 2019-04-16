package JUC.J06_Lock;

import java.util.concurrent.atomic.AtomicBoolean;

/*******************************************************************************
 *乐观锁 与 悲观锁：
 *
 * 悲观锁：总是假设最坏的情况，每次去拿数据的时候都认为别人会修改，所以每次在拿数据的时候都
 *        会上锁，这样别人想拿这个数据就会阻塞直到它拿到锁。传统的关系型数据库里边就用到了
 *        很多这种锁机制，比如行锁，表锁等，读锁，写锁等，都是在做操作之前先上锁。再比如
 *        Java里面的同步原语synchronized关键字的实现也是悲观锁。
 *
 *        悲观锁机制存在以下问题：　　
 *          1. 在多线程竞争下，加锁、释放锁会导致比较多的上下文切换和调度延时，引起性能问题。
 *          2. 一个线程持有锁会导致其它所有需要此锁的线程挂起。
 *          3. 如果一个优先级高的线程等待一个优先级低的线程释放锁会导致优先级倒置，引起性能风险。
 *
 *乐观锁：顾名思义，就是很乐观，每次去拿数据的时候都认为别人不会修改，所以不会上锁，但是在
 *       更新的时候会判断一下在此期间别人有没有去更新这个数据，可以使用版本号等机制。乐观
 *       锁适用于多读的应用类型，这样可以提高吞吐量，像数据库提供的类似于write_condition
 *       机制，其实都是提供的乐观锁。乐观锁具体实现细节：主要就是两个步骤：冲突检测和数据更新。
 *       在Java中java.util.concurrent.atomic包下面的原子变量类就是使用了乐观锁的一种实
 *       现方式CAS实现的。
 *
 * CAS(Compare and Swap 比较并交换):
 *    CAS核心思想：执行函数：CAS(V,E,N)，3个参数：V表示要更新的变量；E表示预期值，N表示新值；
 *    CAS 简单描述" 某一线程认为变量 V 应该是值 A；如果该值当前为A，则更新为B；否则，不要更
 *    改V的值，只告诉我这个位置现在的值即可。"这其实和乐观锁的冲突检查+数据更新的原理是一样的。
 *
 *    CAS缺点：
 *      1. ABA问题：比如说一个线程one从内存位置V中取出A，这时候另一个线程two也从内存中取出A，
 *         并且two进行了一些操作变成了B，然后two又将V位置的数据变成A，这时候线程one进行CAS
 *         操作发现内存中仍然是A，然后one操作成功。尽管线程one的CAS操作成功，但可能存在潜藏
 *         的问题。
 *         解决方法：从Java1.5开始JDK的atomic包里提供了一个类AtomicStampedReference来解
 *         决ABA问题。这个类的compareAndSet方法作用是首先检查当前引用是否等于预期引用，并且
 *         当前标志是否等于预期标志，如果全部相等，则以原子方式将该引用和该标志的值设置为给定
 *         的更新值。
 *      2. 循环时间长开销大：
 * 　　　　 自旋CAS（不成功，就一直循环执行，直到成功）如果长时间不成功，会给CPU带来非常大的执
 *         行开销。如果JVM能支持处理器提供的pause指令那么效率会有一定的提升，pause指令有两个
 *         作用，第一它可以延迟流水线执行指令（de-pipeline）,使CPU不会消耗过多的执行资源，
 *         延迟的时间取决于具体实现的版本，在一些处理器上延迟时间是零。第二它可以避免在退出循
 *         环的时候因内存顺序冲突（memory order violation）而引起CPU流水线被清空（CPU
 *         pipeline flush），从而提高CPU的执行效率。
 *      3. 只能保证一个共享变量的原子操作：
 *         当对一个共享变量执行操作时，我们可以使用循环CAS的方式来保证原子操作，但是对多个共享
 *         变量操作时，循环CAS就无法保证操作的原子性，这个时候就可以用锁，或者有一个取巧的办法，
 *         就是把多个共享变量合并成一个共享变量来操作。比如有两个共享变量i＝2,j=a，合并一下
 *         ij=2a，然后用CAS来操作ij。从Java1.5开始JDK提供了AtomicReference类来保证引用
 *         对象之间的原子性，你可以把多个变量放在一个对象里来进行CAS操作。
 *
 *
 *https://blog.csdn.net/mmoren/article/details/79185862
 *https://www.cnblogs.com/qjjazry/p/6581568.html
 *http://ifeve.com/compare-and-swap/
 ********************************************************************************/
public class testSpinLockCAS {
    public static void main(String[] args){

    }

}
class MyLock {
    //如果同个线程访问同一个MyLock实例，上面的lock()将不能保证正常工作。
    // 如果一个线程检查locked的值，然后将其设置为false，与此同时，一个
    // 线程B也在检查locked的值，又或者，在线程A将locked的值设为false之
    // 前。因此，线程A和线程B可能都看到locked的值为false，然后两者都基
    // 于这个信息做一些操作。
    private boolean locked = false;

    public boolean lock() {
        if(!locked) {
            locked = true;
            return true;
        }
        return false;
    }
}

class MyLock2 {
    //lock()方法是同步的，所以，在某一时刻只能有一个线程在同一个MyLock实例上执行它。
    private boolean locked = false;

    public synchronized boolean lock() {
        if(!locked) {
            locked = true;
            return true;
        }
        return false;
    }
}
class MyLock3 {

    //locked变量不再是boolean类型而是AtomicBoolean。这个类中有一个
    // compareAndSet()方法，它使用一个期望值和AtomicBoolean实例的值
    // 比较，和两者相等，则使用一个新值替换原来的值。在这个例子中，它比较
    // locked的值和false，如果locked的值为false，则把修改为true。如
    // 果值被替换了，compareAndSet()返回true，否则，返回false。
    private AtomicBoolean locked = new AtomicBoolean(false);

    public boolean lock() {
        return locked.compareAndSet(false, true);
    }

}