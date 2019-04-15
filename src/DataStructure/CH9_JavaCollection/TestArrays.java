package DataStructure.CH9_JavaCollection;

import java.util.*;

/***********************************************************************
 * 数组是最常见的数据结构，常用的思想：
 * ①数组的下标与值之间的对应关系，可以通过一定的变换实现Map的功能；
 * ②多个数组实现桶的思想；
 * ③Java 中的Arrays类，是数组的工具类实现了许多数组常见的操作
 *
 * Arrays类中的常用方法：
 *
 *  ①asList(T [] a)                       T必须为包装类型，返回由指定数组
 *                                         支持的固定大小的列表
 *  ②binarySearch(T[] a, T key)           使用二分查找算法搜索数组中的指定值
 *  ③copyOfRange(T[] original, int from, int to) 范围：[from,to)
 *                                         将数组的指定范围复制到新数组中
 *  ④sort(T[] a, int fromIndex, int toIndex)
 *                                         按升序排列数组的指定范围。
 *  ⑤toString(int[] a)                     返回指定数组的内容的字符串表示形式。
 ***********************************************************************/
public class TestArrays {
    public static void main(String [] args){
        int [] arr =  {2,34,23,24,56,78,12,67,89,37};
        Arrays.sort(arr);
        System.out.println(Arrays.binarySearch(arr,67));
        System.out.println(Arrays.toString(arr));
        int [] array = Arrays.copyOfRange(arr,3,5);
        System.out.println(Arrays.toString(array));

    }
}
