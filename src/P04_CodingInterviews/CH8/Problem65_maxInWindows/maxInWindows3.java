package P04_CodingInterviews.CH8.Problem65_maxInWindows;

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
//前两种方法的复杂度都是O(n*size)
public class maxInWindows3 {
    public static void main(String [] args){
        int [] nums = {16,14,12,10,8,6,4};

        System.out.println(maxInWindows(nums,5));

    }
    public static ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(size == 0 || size > num.length) return list;
        Queue<Integer> queue = new LinkedList<>();
        int temp = 0;
        for(int i = 0; i<num.length;i++){
            if(queue.isEmpty())
                queue.offer(i);
            else if(num[i] > num[queue.peek()]){
                queue.poll();
                queue.offer(i);
            }
            if(i+1 >= size){
                list.add(num[queue.peek()]);
                if(i+1 -size >= queue.peek()){
                    temp = 1+ queue.poll();
                    while(temp <= i){
                        if(queue.isEmpty())
                            queue.offer(temp);
                        else if(num[temp] > num[queue.peek()]){
                            queue.poll();
                            queue.offer(temp);
                        }
                        temp++;
                    }
                }
            }
        }

        return list;
    }
}
