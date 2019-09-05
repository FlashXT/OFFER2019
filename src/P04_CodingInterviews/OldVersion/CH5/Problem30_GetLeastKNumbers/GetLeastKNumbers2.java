package P04_CodingInterviews.OldVersion.CH5.Problem30_GetLeastKNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/5/12 21:57
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class GetLeastKNumbers2 {
    public static void main(String [] args){
        int [] arr = {2,3,4,51,2,23,323,35,565,1,24};
        ArrayList<Integer> list = GetLeastKNumbers(arr,0);
        System.out.println(Arrays.toString(list.toArray()));

    }
    public static ArrayList<Integer> GetLeastKNumbers(int [] arr,int k){
        ArrayList<Integer> list = new ArrayList<Integer>();
        if( k <=0 || arr.length < k) return list;
        Comparator<Integer> cmp = new Comparator<Integer>() {
            public int compare(Integer e1, Integer e2) {
                return e2 - e1;
            }
        };
        PriorityQueue<Integer> queue = new PriorityQueue<>(k,cmp);
        for(int i = 0; i < arr.length;i++){
            if(queue.size()!=k){
                queue.offer(arr[i]);
            }
            else{
                if(arr[i] < queue.peek()){
                    queue.remove();
                    queue.offer(arr[i]);
                }
            }
        }

        list = new ArrayList<>(queue);

        return list;

    }

}


