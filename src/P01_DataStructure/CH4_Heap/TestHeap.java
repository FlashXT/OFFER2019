package P01_DataStructure.CH4_Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/8/23,11:03
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class TestHeap {
    public static void main(String [] args){
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            //o1表示新来的元素，o2表示Heap中的元素
            public int compare(Integer o1, Integer o2) {
                //返回负值表示不需要调整顺序，返回正值表示需要调整顺序
                return o2 - o1;
            }
        };

        PriorityQueue heap = new PriorityQueue(com);

        heap.add(34);heap.add(3);heap.add(12);heap.add(45);

        while(heap.size()!=0)
            System.out.print(heap.poll()+"\t");
        System.out.println();

    }

}
