package P04_CodingInterviews.P042_FindNumbersWithSum;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/16,14:13
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
/*
    题目:输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
         如果有多对数字的和等于S，输出两个数的乘积最小的。
    输出描述:对应每个测试案例，输出两个数，小的先输出。
 */
public class Main {
    public static void main(String [] args){
        int [] nums = {1,2,4,7,11,15};
        new Method1().FindNumbersWithSum(nums,11);
    }
}
