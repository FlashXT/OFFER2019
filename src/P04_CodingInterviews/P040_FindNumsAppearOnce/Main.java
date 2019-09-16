package P04_CodingInterviews.P040_FindNumsAppearOnce;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/16,10:47
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
/*
   题目:一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class Main {
    public static void main(String [] args){
        int [] nums = {2,4,3,6,3,2,5,5};
        int [] num1 = new int[1];
        int [] num2 = new int[1];
        new Method1().FindNumsAppearOnce(nums,num1,num2);
        System.out.print(num1[0]+" "+num2[0]);
    }
}
