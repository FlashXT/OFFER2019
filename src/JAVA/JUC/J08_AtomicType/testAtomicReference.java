package JAVA.JUC.J08_AtomicType;

import java.util.concurrent.atomic.AtomicReference;

/***********************************************************************
 * AtomicReference 提供了一个可以被原子性读和写的对象引用变量。原子性的意思是多
 * 个想要改变同一个 AtomicReference 的线程不会导致 AtomicReference 处于不一
 * 致的状态。AtomicReference 还有一个 compareAndSet() 方法，通过它你可以将当
 * 前引用于一个期望值(引用)进行比较，如果相等，在该 AtomicReference 对象内部设置
 * 一个新的引用。
 ***********************************************************************/
public class testAtomicReference {
    public static void main(String [] args){
        AtomicReference atomref = new AtomicReference();
        String initialReference = "the initially referenced string";
        AtomicReference atomref2 = new AtomicReference(initialReference);

        //创建泛型 AtomicReference
        AtomicReference<String> atomicStringReference = new AtomicReference<String>();
        String initref = "the initially referenced string";
        AtomicReference<String> atomicStringRef = new AtomicReference<String>(initialReference);

        //获取 AtomicReference 引用
        //可以通过 AtomicReference 的get()方法来获取保存在 AtomicReference 里的引用。
        //如果你的 AtomicReference 是非泛型的，get() 方法将返回一个 Object 类型的引用。
        //如果是泛型化的，get() 将返回你创建 AtomicReference 时声明的那个类型。
        AtomicReference atomicReference = new AtomicReference("first value referenced");
        String str = (String)atomicReference.get();
        System.out.println(str);
        System.out.println(atomicReference);
        //设置 AtomicReference引用
        //可以使用 get() 方法对 AtomicReference 里边保存的引用进行设置。如果你定义的是
        //一个非泛型 AtomicReference，set() 将会以一个 Object 引用作为参数。如果是泛
        //型化的 AtomicReference，set() 方法将只接受你定义给的类型。
        AtomicReference atomicRef = new AtomicReference();
        atomicRef.set("New object referenced");
        System.out.println(atomicRef);

        //比较并设置 AtomicReference 引用
        //AtomicReference 类具备了一个很有用的方法：compareAndSet()。compareAndSet()
        //可以将保存在 AtomicReference 里的引用于一个期望引用进行比较，如果两个引用是一样
        //的(并非 equals() 的相等，而是 == 的一样)，将会给 AtomicReference 实例设置一个
        //新的引用。如果 compareAndSet() 为 AtomicReference 设置了一个新的引用，
        //compareAndSet() 将返回 true,否则 compareAndSet() 返回 false。
        String initialRef = "initial value referenced";
        AtomicReference<String> atomicStrRef = new AtomicReference<>(initialRef);

        String newReference = "new value referenced";
        boolean exchanged = atomicStrRef.compareAndSet(initialRef, newReference);
        System.out.println("exchanged: " + exchanged);
        exchanged = atomicStrRef.compareAndSet(initialRef, newReference);
        System.out.println("exchanged: " + exchanged);

    }
}
