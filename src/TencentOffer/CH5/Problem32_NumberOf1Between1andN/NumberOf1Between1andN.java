package TencentOffer.CH5.Problem32_NumberOf1Between1andN;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/5/13 18:48
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class NumberOf1Between1andN {
    public static void main(String [] args){
        System.out.println(NumberOf1Between1andN(12));
    }
    public static int NumberOf1Between1andN(int N){
        int sum = 0,num;
        for(int i = 1; i <= N;i++){
            num = i;
            while(num > 0){
                if(num%10 == 1) sum++;
                num = num/10;

            }
        }
        return sum;
    }
}
