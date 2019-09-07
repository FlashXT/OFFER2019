package P04_CodingInterviews.P013_ReOrderArray;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/7 11:23
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
/*
    题目:输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于
    数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间
    的相对位置不变。
 */
public class Main {
    public static  void main(String [ ]args){
        int [] arr = {1,2,3,4,10,6,7,8};
//        new Method1().reOrderArray(arr);
        new Method2().reOrderArray(arr);
    }
}
