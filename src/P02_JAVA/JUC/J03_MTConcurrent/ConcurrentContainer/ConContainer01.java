package P02_JAVA.JUC.J03_MTConcurrent.ConcurrentContainer;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/*****************************************************************************************
 * JDK5中添加了新的concurrent包，相对同步容器而言，并发容器通过一些机制改进了并发性能。因为同步容器将所
 * 有对容器状态的访问都串行化了，这样保证了线程的安全性，所以这种方法的代价就是严重降低了并发性，当多个线程
 * 竞争容器时，吞吐量严重降低。因此Java5.0开始针对多线程并发访问设计，提供了并发性能较好的并发容器，引入了
 * java.util.concurrent包。与Vector和Hashtable、Collections.synchronizedXxx()同步容器等相比，
 * util.concurrent中引入的并发容器主要解决了两个问题：
 *      1）根据具体场景进行设计，尽量避免synchronized，提供并发性。
 *      2）定义了一些并发安全的复合操作，并且保证并发环境下的迭代操作不会出错。
 *　util.concurrent中容器在迭代时，可以不封装在synchronized中，可以保证不抛异常，但是未必每次看到的都是
 * "最新的、当前的"数据。
 *
 ******************************************************************************************/
public class ConContainer01 {
    public static void main(String [] args){
        testHashmap();
        testNavigablemap();
    }
    public static void testHashmap(){
        /********************************************************************************
         * ConcurrentHashMap(https://www.cnblogs.com/dolphin0520/p/3932905.html)
         * ConcurrentHashMap代替同步的Map(Collections.synchronized(new HashMap()))，
         * 众所周知,HashMap是根据散列值分段存储的，同步Map在同步的时候锁住了所有的段，而
         * ConcurrentHashMap加锁的时候根据散列值锁住了散列值锁对应的那段，因此提高了并发性能。
         * ConcurrentHashMap也增加了对常用复合操作的支持，比如"若没有则添加"：putIfAbsent()，
         * 替换：replace()。这2个操作都是原子操作。
         *******************************************************************************/
        ConcurrentHashMap<Double,String> cmap = new ConcurrentHashMap<>();
        int i = 0;
        while(i++< 300){
            new Thread(()->{
                cmap.put(Math.random()*1000,"AAA");
            }).start();
            new Thread(()->{
                cmap.put(1000+Math.random()*1000,"BBB");
            }).start();
            new Thread(()->{
                cmap.put(2000+Math.random()*1000,"CCC");
            }).start();
        }

        System.out.println(cmap.toString());
        System.out.println(cmap.size());
    }
    public static void testNavigablemap(){
        /*************************************************************************
         * java.util.concurrent.ConcurrentNavigableMap 是一个支持并发访问的
         * java.util.NavigableMap，它还能让它的子 map 具备并发访问的能力。所谓的 “子 map”
         * 指的是诸如 headMap()，subMap()，tailMap() 之类的方法返回的 map。
         *************************************************************************/
        //headMap()
        //headMap(T toKey) 方法返回一个包含了小于给定 toKey 的 key 的子 map。
        //如果你对原始 map 里的元素做了改动，这些改动将影响到子 map 中的元素(注：map 集合持有
        //的其实只是对象的引用)。
        ConcurrentNavigableMap<String,String> map = new ConcurrentSkipListMap<>();
        map.put("1","one");
        map.put("2","two");
        map.put("3","three");
        map.put("4","four");
        ConcurrentNavigableMap<String,String> headmap = map.headMap("3");
        System.out.println(headmap);

        //tailMap()
        //tailMap(T fromKey) 方法返回一个包含了不小于给定 fromKey 的 key 的子 map。
        //如果你对原始 map 里的元素做了改动，这些改动将影响到子 map 中的元素(注：map 集合持有
        //的其实只是对象的引用)。

        ConcurrentNavigableMap<String,String> tailmap = map.tailMap("3");
        System.out.println(tailmap);
        //subMap()
        //subMap() 方法返回原始 map 中，键介于 [from,to)之间的子 map。

        ConcurrentNavigableMap subMap = map.subMap("2", "4");
        System.out.println(subMap);

        //将map中的元素按键值降序排序后返回
        ConcurrentNavigableMap dmap = map.descendingMap();
        System.out.println(dmap);



    }

}
