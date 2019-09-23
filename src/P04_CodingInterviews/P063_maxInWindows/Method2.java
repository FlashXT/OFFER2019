package P04_CodingInterviews.P063_maxInWindows;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/19,21:07
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
//最大堆
public class Method2 {
    public ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> res = new ArrayList<>();
        if(size == 0 || size > num.length) return res;
        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };
        PriorityQueue<Integer> heap = new PriorityQueue<>(cmp);
        for(int i = 0 ; i < size;i++)
            heap.add(num[i]);
        res.add(heap.peek());
        for(int i = size; i < num.length;i++){
            heap.remove(num[i-size]);
            heap.add(num[i]);
            res.add(heap.peek());
        }

        return res;

    }

}
