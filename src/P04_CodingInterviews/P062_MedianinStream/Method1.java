package P04_CodingInterviews.P062_MedianinStream;

import java.util.Comparator;
import java.util.PriorityQueue;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/19,20:40
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    Comparator<Integer> cmp1 = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    };
    Comparator<Integer> cmp2 = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    };
    PriorityQueue<Integer> smallheap = new PriorityQueue<>(cmp1);
    PriorityQueue<Integer> bigheap = new PriorityQueue<>(cmp2);
    //新元素默认放进小根堆；如果当前元素小于小根堆的堆顶则放入大根堆；否则放入小根堆；
    //同时保证大根堆和小根堆的元素数量之差不大于1
    public void Insert(Integer num) {
        if(!smallheap.isEmpty() && num < smallheap.peek())
            bigheap.offer(num);
        else
            smallheap.offer(num);
        if(smallheap.size() - bigheap.size() >1)
            bigheap.offer(smallheap.poll());
        if(smallheap.size() - bigheap.size() < -1)
            smallheap.offer(bigheap.poll());
    }

    public Double GetMedian() {
        if(smallheap.size()== bigheap.size())
            return (bigheap.peek()+smallheap.peek())/2.0;
        else if(smallheap.size()> bigheap.size())
            return (double)smallheap.peek();
        else
            return (double)bigheap.peek();

    }

}
