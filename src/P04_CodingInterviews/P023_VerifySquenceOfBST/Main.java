package P04_CodingInterviews.P023_VerifySquenceOfBST;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/8 21:52
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
/*
    题目:输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是
        则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Main {
    public static void main(String [] args){
        int [] nums = {5,7,6,9,11,10,8};
        new Method1().VerifySquenceOfBST(nums);
    }
}
