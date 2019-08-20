package P04_CodingInterviews.CH6.Problem47_BitOpSum;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/16 8:52;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/

/*********************************************
 * 二进制加法：异或求本位；相与左移求进位；循环移位
 *********************************************/
public class Problem47_BitOpSum {
    public static void main(String [] args){
        System.out.println(AddR(12,3));

    }

    //循环
    public static int Add(int num1,int num2) {
        //3.将上述两步的结果相加(循环移位计算)
        while( num2!=0 ){
            //1.两个数异或：相当于每一位相加，而不考虑进位；
            int sum = num1 ^ num2;
            //2.两个数相与，并左移一位：相当于求得进位；
            int carray = (num1 & num2) << 1;
            num1 = sum;
            num2 = carray;
        }
        return num1;
    }
    //递归
    public static int AddR(int num1,int num2) {

        if(num2 == 0) return 0;
        return num1^num2+AddR(num1^num2,(num1&num2)<<1);
    }

}
