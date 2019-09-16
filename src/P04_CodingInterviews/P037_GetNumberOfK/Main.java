package P04_CodingInterviews.P037_GetNumberOfK;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/16,9:23
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
//题目:统计一个数字在排序数组中出现的次数。
public class Main {
    public static void main(String [] args){
        int [] nums = {3,3,3,3,4,5};
        int res = new Method1().GetNumberOfK(nums,3);
        System.out.print(res);
    }
}
