package TencentOffer.CH8.Problem63_GetMidMin;

import java.util.Comparator;
import java.util.PriorityQueue;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/5/16 22:16
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class GetMidMin {
    static Comparator<Integer> cmp = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            if( o1 > o2)
                return -1;
            else
                return 1;
        }
    };
    static PriorityQueue<Integer> smallheap = new PriorityQueue<>();
    static PriorityQueue<Integer> bigheap = new PriorityQueue<>(cmp);
    public static  int count = 0;

    public static void main(String [] args){
        int [] arr = {1,2,3,4,5,6,7,8,9,10};
        for(int i = 1; i < arr.length;i++){
            Insert(arr[i]);
            System.out.println(GetMidMin());
        }

    }
    public static void Insert(int num){
        count++;
        //元素总数为偶数个，新元素先入小根堆
        if( (count&1) == 0){
            smallheap.offer(num);
            if(smallheap.size() - bigheap.size() >1)
                bigheap.offer(smallheap.poll());

        }
        //元素总数为奇数个，新元素先入大根堆
        else{
            bigheap.offer(num);
            if (bigheap.size() - smallheap.size() > 1)
                smallheap.offer(bigheap.poll());
        }

    }
    public static double GetMidMin(){

        if((count&1) == 0)
            return (bigheap.peek()+smallheap.peek())/2.0;
        else
            return bigheap.peek();
    }
}
