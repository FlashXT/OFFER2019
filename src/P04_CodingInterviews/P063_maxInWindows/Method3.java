package P04_CodingInterviews.P063_maxInWindows;

import java.util.*;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/19,21:07
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
//双端队列：队列中存储元素下标，队列中的第一个值保存当前窗口中的最大值，当窗口滑动一次：
// 1.判断当前最大值是否过期
// 2.新增加的值从队尾开始比较，丢掉所有比他小的值
public class Method3 {
    public ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> res = new ArrayList<>();
        if(size == 0 || size > num.length) return res;
        Deque<Integer> queue = new LinkedList<>();
        int start;
        for(int i = 0; i < num.length;i++){
            //start表示当前窗口的开始下标
            start = i -size+1;
            if(queue.isEmpty()) queue.add(i);
            else  if(start > queue.peekFirst())
                queue.pollFirst();
            while(!queue.isEmpty() && num[queue.peekLast()] <=num[i]){
                queue.pollLast();
            }
            queue.add(i);
            if(start >= 0)
                res.add(num[queue.peekFirst()]);

        }
        return res;

    }

}
