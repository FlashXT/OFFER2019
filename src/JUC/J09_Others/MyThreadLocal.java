package JUC.J09_Others;

/*****************************************************************************************
 *   在Thread类中定义了一个threadLocals，它是ThreadLocal.ThreadLocalMap对象的引用,默认值
 *是null。ThreadLocal.ThreadLocalMap对象表示了一个以开放地址形式的散列表。当我们在线程的run
 *方法中第一次调用ThreadLocal对象的get方法时，会为当前线程创建一个ThreadLocalMap对象。也就是
 *每个线程都各自有一张独立的散列表，以ThreadLocal对象作为散列表的key，set方法中的值作为value
 *(第一次调用get方法时，以initialValue方法的返回值作为value)。显然我们可以定义多个ThreadLocal
 *对象，而我们一般将ThreadLocal对象定义为static类型或者外部类中。上面所表达的意思就是，相同的key
 *在不同的散列表中的值必然是独立的，每个线程都是在各自的散列表中执行操作。
 *ThreadLocal中的方法：
 *      1、ThreadLocal.get: 获取ThreadLocal中当前线程共享变量的值。
 *
 *      2、ThreadLocal.set: 设置ThreadLocal中当前线程共享变量的值。
 *
 *      3、ThreadLocal.remove: 移除ThreadLocal中当前线程共享变量的值。
 *
 *      4、ThreadLocal.initialValue: ThreadLocal没有被当前线程赋值时或当前线程刚调用
 *         remove方法后调用get方法，返回此方法值。
 *防止ThreadLocal内存泄漏：
 *在不再使用某个ThreadLocal对象后，手动调用remoev方法来删除它,各自线程中调用共享的ThreadLocal对象
 *的remove方法，这对其它线程是没有影响的。
 *http://www.cnblogs.com/nullzx/p/7553538.html
 ******************************************************************************************/
public class MyThreadLocal {
    static ThreadLocal<String>  tl1 = new ThreadLocal<>();
    static ThreadLocal<Integer> tl2 = new ThreadLocal<>();
    static ThreadLocal<Boolean> tl3 = new ThreadLocal<>();
    public static void main(String [] args){

        for(int i = 0; i < 3; i++){
            new Thread(()->{
                tl1.set("tl1XXX");
                System.out.println(Thread.currentThread().getName()+"tl1:"+tl1.get());
            }).start();
            new Thread(()->{
                tl1.set("tl1AAA");
                tl2.set(123456);
                System.out.println(Thread.currentThread().getName()+"tl1:"+tl1.get());
                System.out.println(Thread.currentThread().getName()+"tl2:"+tl2.get());
            }).start();
            new Thread(()->{
                tl3.set(false);
                System.out.println(Thread.currentThread().getName()+"tl3:"+tl3.get());
            }).start();
        }

    }

}
