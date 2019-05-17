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

    public static void main(String [] args){
        int [] arr = {5,2,3,4,1,6,7,0,8};
        for(int i = 0; i < arr.length;i++){
            Insert(arr[i]);
            System.out.println(GetMidMin());
        }

    }
    public static void Insert(int num){

        //新元素默认放进小根堆；如果当前元素小于小根堆的堆顶则放入大根堆；否则放入小根堆；
        //同时保证大根堆和小根堆的元素数量之差不大于1
        if(!smallheap.isEmpty()&&num < smallheap.peek())
            bigheap.offer(num);
        else
            smallheap.offer(num);
        if(smallheap.size() - bigheap.size() >1)
            bigheap.offer(smallheap.poll());
        if(smallheap.size() - bigheap.size() <-1)
            smallheap.offer(bigheap.poll());

    }
    public static double GetMidMin(){

        if(smallheap.size()== bigheap.size())
            return (bigheap.peek()+smallheap.peek())/2.0;
        else if(smallheap.size()> bigheap.size())
            return smallheap.peek();
        else
            return bigheap.peek();
    }
}
