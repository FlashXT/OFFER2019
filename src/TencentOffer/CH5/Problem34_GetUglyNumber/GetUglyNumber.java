package TencentOffer.CH5.Problem34_GetUglyNumber;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/5/14 18:47
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class GetUglyNumber {
    public static void main(String [] args){
        System.out.println(GetUglyNumber(3));
    }
    public static int GetUglyNumber(int index){
        if(index <= 0)
            return 0;
        int num = 0;
        int uglyFound = 0;
        while(uglyFound < index){
            ++num;
            if(isUgly(num)){
                uglyFound++;
            }

        }
        return num;
    }
    public static boolean isUgly(int num){
        while(num%2 == 0)
            num/=2;
        while(num%3 == 0)
            num/=3;
        while(num%5 == 0)
            num/=5;

        return (num == 1)?true:false;

    }
}
