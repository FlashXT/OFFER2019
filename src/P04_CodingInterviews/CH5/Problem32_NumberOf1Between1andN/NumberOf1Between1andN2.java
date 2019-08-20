package P04_CodingInterviews.CH5.Problem32_NumberOf1Between1andN;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/5/13 18:48
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class NumberOf1Between1andN2 {
    public static void main(String [] args){

        System.out.println(Numberof1(534));
    }

    public static int Numberof1(int n){
        int weight = 0;
        int base = 1;
        int round = n;
        int res = 0;
        while( round > 0){

            weight = round%10;
            round = round/10;
            res += round *base;
            if(weight == 1)
                res+=(n%base)+1;
            else if(weight >1)
                res +=base;
            base*=10;
        }
        return res;
    }
}
