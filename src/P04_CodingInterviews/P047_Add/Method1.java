package P04_CodingInterviews.P047_Add;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/16,22:03
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public int Add(int num1,int num2) {
        int carry = 0;
        while(num2!=0){
            int temp = num1 ^num2;
            carry = (num1&num2)<<1;
            num1 = temp;
            num2 = carry;

        }
        return num1;
    }
}
