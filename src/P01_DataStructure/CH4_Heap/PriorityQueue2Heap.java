package P01_DataStructure.CH4_Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/5/12 22:43
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
/***************************************************************************
 * 在使用Comparator时，返回值与升降序的关系如下：
 * //这里o1表示新来的元素，o2表示Heap中的元素
 * if(o1.compareTo(o2) < 0 ){
 *     return ?;
 * }
 *
 * //如果你想升序，那么o1比o2小就是我想要的；所以返回-1，类比成false；表示我不想调整顺序
 * //如果你想降序，那么o1比o2小不是我想要的；所以返回 1，类比成true； 表示我想调整顺序
 ****************************************************************************/
//使用 java PriorityQueue实现大顶堆和小顶堆;PriorityQueue内并不会对数据元素进行
// 排序建堆，只是在输出元素时按照堆的顺序输出；
public class PriorityQueue2Heap {
    public static void main(String [] args){
        int [] arr ={3,12,45,56,34,21,6};
        PriorityQueue<Integer> Heap = upHeap(arr);
        while(Heap.size()!=0)
            System.out.println(Heap.poll());

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
//        Comparator<Integer> cmp = ((o1,o2)->o1>o2?-1:1);
        Comparator<Integer> cmp =new Comparator<Integer>() {

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
