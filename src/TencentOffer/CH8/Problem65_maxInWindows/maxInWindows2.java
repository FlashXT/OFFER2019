package TencentOffer.CH8.Problem65_maxInWindows;

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
public class maxInWindows2 {
    public static void main(String [] args){
        int [] nums = {2,3,4,2,6,2,5,1};
        Stack<Integer> stack1 = new Stack<>();

        System.out.println(maxInWindows(nums,3));

    }
    public static ArrayList<Integer> maxInWindows(int [] num, int size){

        ArrayList<Integer> list = new ArrayList<Integer>();
        if(size == 0 || size > num.length) return list;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int max = Integer.MIN_VALUE;
        for(int i =0 ;i < size;i++){
            stack1.push(num[i]);
        }
        for(int i = size;i< num.length;i++){
            max = Integer.MIN_VALUE;
            while(!stack1.isEmpty()){
                max = stack1.peek() > max ?stack1.peek():max;
                stack2.push(stack1.pop());
            }
            list.add(max);
            stack2.pop();
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            stack1.push(num[i]);
        }
        max = Integer.MIN_VALUE;
        while(!stack1.isEmpty()){
            max = stack1.peek() > max ?stack1.peek():max;
            stack1.pop();
        }
        list.add(max);

        return list;
    }
}
