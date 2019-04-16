package JAVA.JUC.J03_MTConcurrent.ConcurrentContainer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/****************************************************************************
 * Copy-On-Write简称COW，是一种用于程序设计中的优化策略。其基本思路是，从一开始大家都在共
 * 享同一个内容，当某个人想要修改这个内容的时候，才会真正把内容Copy出去形成一个新的内容然后
 * 再改，这是一种延时懒惰策略。从JDK1.5开始Java并发包里提供了两个使用CopyOnWrite机制实现
 * 的并发容器,它们是CopyOnWriteArrayList和CopyOnWriteArraySet。
 *   CopyOnWrite容器即写时复制的容器。通俗的理解是当我们往一个容器添加元素的时候，不直接往
 * 当前容器添加，而是先将当前容器进行Copy，复制出一个新的容器，然后新的容器里添加元素，添加
 * 完元素之后，再将原容器的引用指向新的容器。这样做的好处是可以对CopyOnWrite容器进行并发的
 * 读，而不需要加锁，因为当前容器不会添加任何元素。所以CopyOnWrite容器也是一种读写分离的思
 * 想，读和写不同的容器。
 *
 *                  CopyOnWrite并发容器用于读多写少的并发场景。
 *
 *   CopyOnWriteArrayList和CopyOnWriteArraySet分别代替List和Set，主要是在遍历操作为
 * 主的情况下来代替同步的List和同步的Set，这也就是上面所述的思路：迭代过程要保证不出错，
 * 除了加锁，另外一种方法就是"克隆"容器对象。
 * https://www.cnblogs.com/dolphin0520/p/3938914.html
 *
 * CopyOnWrite容器缺点：内存占用问题：数据一致性问题。
 *  ①内存占用问题。因为CopyOnWrite的写时复制机制，所以在进行写操作的时候，内存里会同时驻扎
 *  两个对象的内存，旧的对象和新写入的对象（注意:在复制的时候只是复制容器里的引用，只是在写的
 *  时候会创建新对象添加到新容器里，而旧容器的对象还在使用，所以有两份对象内存）。
 *  ②数据一致性问题。CopyOnWrite容器只能保证数据的最终一致性，不能保证数据的实时一致性。所
 *  以如果你希望写入的的数据，马上能读到，请不要使用CopyOnWrite容器。
 ****************************************************************************/
public class ConContainer02 {
    public static void main(String [] args){
        testCOWList();
        testCOWSet();
        testCOWMap();
    }
    public static void testCOWList(){
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("e");
        System.out.println(list.toString());
    }
    public static void testCOWSet(){
        CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        System.out.println(set.toString());

    }
    public static void  testCOWMap(){
        CopyOnWriteMap<String,String>  cowmap = new CopyOnWriteMap<>();
        cowmap.put("1","one");
        cowmap.put("2","two");
        cowmap.put("3","three");
        cowmap.put("4","four");
        System.out.println(cowmap);
    }
}

class CopyOnWriteMap<K, V> extends HashMap<K, V> {
    //CopyOnWriteMap实现
    private volatile Map<K, V> internalMap;

    public CopyOnWriteMap() {
        internalMap = new HashMap<K, V>();
    }

    public V put(K key, V value) {

        synchronized (this) {
            //COW
            Map<K, V> newMap = new HashMap<K, V>(internalMap);
            V val = newMap.put(key, value);
            internalMap = newMap;

            return val;
        }
    }

    public V get(Object key) {
        return internalMap.get(key);
    }

    public void putAll(Map<? extends K, ? extends V> newData) {
        synchronized (this) {
            Map<K, V> newMap = new HashMap<K, V>(internalMap);
            newMap.putAll(newData);
            internalMap = newMap;
        }
    }

    public String toString(){
        return this.internalMap.toString();
    }
}