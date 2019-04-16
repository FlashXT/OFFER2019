package JAVA.JUC.J03_MTConcurrent.SynchronizedContainer;

import java.util.ArrayList;
import java.util.Iterator;

/************************************************************************************
 * 同步容器异常：https://www.cnblogs.com/dolphin0520/p/3933551.html
 * ConcurrentModificationException异常:
 * 　在对Vector等容器并发地进行迭代修改时，会报ConcurrentModificationException异常；
 *************************************************************************************/
public class synContainer02 {
    public static void main(String[] args){
        testConModificationException1();
    }
    public static void testConModificationException1(){
        //
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
          Integer integer = iterator.next();
            if(integer==2)
                list.remove(integer);
//                iterator.remove();
        }

    }
}
