package Test.TrendTest.Problem2;

import java.util.Arrays;

/*****************************************************************
 * @Author:turboMan;
 * @Date:19-8-8 下午9:46;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class MoneyNums {
    private static int res = 0;
    public static void main(String [] args){
        int [] money ={1,5,10,20,50,100};
        int [] nums = {6,5,4,3,2,1};
        int [] left = {6,5,4,3,2,1};
        System.out.println(Arrays.toString(money));
        Money(11,money,left,nums,0);
        System.out.println(res);


    }
    public static void Money(int sum,int [] money,int [] left,int [] nums,int currsum){
        if(currsum > sum) {
            return ;
        }

        if(currsum == sum){
            for(int i = 0 ;i < nums.length;i++)
                res+= nums[i]-left[i];
            for(int i = 0; i< nums.length;i++)
                System.out.print(nums[i]-left[i]+"\t");
            System.out.println();
            return ;
        }
        for(int i = 0; i< money.length;i++){
            if(left[i] >0){
                for(int j = 1; j <= left[i];j++){
                    currsum+=money[i]*j;
                    left[i]-=j;
                    Money(sum,money,left,nums,currsum);
                    currsum-=money[i]*j;
                    left[i]+=j;
                }
            }

        }
    }
}
