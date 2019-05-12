package DataStructure.CH4_Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/5/12 22:43
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
//使用 java PriorityQueue实现大顶堆和小顶堆
public class PriorityQueue2Heap {
    public static void main(String [] args){
        int [] arr ={3,12,45,56,34,21,6};
        PriorityQueue<Integer> Heap = upHeap(arr);
        System.out.println(Arrays.toString(Heap.toArray()));

    }
    //ProrityQueue默认小顶堆
    public static PriorityQueue<Integer> lowHeap(int [] arr){
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i = 0; i < arr.length;i++){
            heap.offer(arr[i]);
        }
        return heap;
    }
    //实现大顶堆，需要自己实现比较器
    public static PriorityQueue<Integer> upHeap(int [] arr){
        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };
        PriorityQueue<Integer> heap = new PriorityQueue<>(cmp);
        for(int i = 0; i < arr.length;i++){
            heap.offer(arr[i]);
        }
        return heap;
    }

}
