package P01_DataStructure.CH4_Heap;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/13 9:23;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/

import java.util.Comparator;
import java.util.PriorityQueue;

/***************************************************************************
 * 在使用Comparator时，返回值与升降序的关系如下：
 * //这里o1表示位于前面的字符，o2表示后面的字符
 * if(o1.compareTo(o2) < 0 ){
 *     return ?;
 * }
 *
 * //上面的条件：o1比o2小，这个时候，我们需要需要调整它们的顺序
 * //如果你想升序，那么o1比o2小就是我想要的；所以返回-1，类比成false；表示我不想调整顺序
 * //如果你想降序，那么o1比o2小不是我想要的；所以返回 1，类比成true； 表示我想调整顺序
 ****************************************************************************/
public class TestComparator {
    public static void main(String [] args){
        int [] arr ={1,2,3,4,5,6,7};
        Comparator<Integer> cmp =((o1, o2) -> o1 > o2 ? 1 : -1);
        PriorityQueue queue = new PriorityQueue(cmp);
        for(int i = 0; i< arr.length;i++)
            queue.offer(arr[i]);
        while(queue.size()!=0){
            System.out.println(queue.poll());
        }
    }

}
