package P04_CodingInterviews.CH8.Problem65_maxInWindows;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/17 8:57;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/

import java.util.ArrayList;
import java.util.LinkedList;

/**********************************************************************
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组
 * {2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别
 * 为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 **********************************************************************/
//前两种方法的复杂度都是O(n*size)
public class maxInWindows4 {
    public static void main(String [] args){
        int [] nums = {2,3,4,2,6,2,5,1};

        System.out.println(maxInWindows(nums,3));

    }

    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if(num == null || num.length == 0 || size == 0 || size > num.length) {
            return result;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < num.length;i++){
            if(queue.isEmpty()){
                queue.offer(i);
            }
            else if(num[i] > num[queue.getLast()]){
                while(!queue.isEmpty()&&num[i] > num[queue.getLast()]){
                    queue.pollLast();
                }
                queue.offer(i);
            }
            else if(num[i] < num[queue.getLast()])
                queue.offer(i);
            if(i+1 >= size){
                result.add(num[queue.peek()]);
            }
            if(i+1-queue.peek() >= size){
                queue.poll();
            }
        }
        return result;
    }
}
