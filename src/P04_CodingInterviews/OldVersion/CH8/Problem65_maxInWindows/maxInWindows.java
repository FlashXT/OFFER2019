package P04_CodingInterviews.OldVersion.CH8.Problem65_maxInWindows;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/17 8:57;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/

import java.util.*;

/**********************************************************************
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组
 * {2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别
 * 为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 **********************************************************************/
public class maxInWindows {
    public static void main(String [] args){
        int [] nums = {2,3,4,2,6,2,5,1};
        System.out.println(maxInWindows(nums,3));

    }
    public static ArrayList<Integer> maxInWindows(int [] num, int size){
        Queue<Integer> queue = new LinkedList<Integer>();
        Comparator<Integer> cmp = new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                if( o1 > o2)
                    return -1;
                else
                    return 1;
            }
        };
        PriorityQueue<Integer> heap = new PriorityQueue<>(cmp);
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(size == 0 || size > num.length) return list;
        for(int i = 0; i < size;i++){
            queue.offer(num[i]);
            heap.offer(num[i]);
        }
        list.add(heap.peek());
        for(int i = size; i < num.length;i++){
            heap.remove(queue.poll());

            queue.offer(num[i]);
            heap.offer(num[i]);
            list.add(heap.peek());
        }
        return list;
    }
}
