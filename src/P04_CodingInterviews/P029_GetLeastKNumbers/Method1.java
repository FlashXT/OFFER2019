package P04_CodingInterviews.P029_GetLeastKNumbers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/10 16:23
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] arr, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(k > arr.length || k == 0) return res;
        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        };
        PriorityQueue<Integer> heap = new PriorityQueue<>(cmp);
        for(int i = 0; i< arr.length;i++){
            if(heap.size() < k)
                heap.offer(arr[i]);
            else{
                if(arr[i] < heap.peek()){
                    heap.poll();
                    heap.offer(arr[i]);
                }
            }
        }
        while(!heap.isEmpty()){
            res.add(heap.poll());
        }
        return res;
    }
}
