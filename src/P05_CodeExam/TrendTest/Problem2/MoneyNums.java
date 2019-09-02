package P05_CodeExam.TrendTest.Problem2;

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
        Money(100,money,left,0,nums,0);
        System.out.println(res);


    }
    public static boolean Money(int sum,int [] money,int [] left,int index,int [] nums,int currsum){
        if(currsum > sum) {
            return false;
        }

        if(currsum == sum){
            for(int i = 0 ;i < nums.length;i++)
                res+= nums[i]-left[i];
            for(int i = 0; i< nums.length;i++)
                System.out.print(nums[i]-left[i]+"\t");
            System.out.println();
            return true;
        }
        for(int i = index; i< money.length;i++){
            if(left[i] >0){
                for(int j = 1; j <= left[i];j++){
                    currsum+=money[i]*j;
                    left[i]-=j;
                    //Money()返回false,表示currsum已经大于sum,没必要继续在当前面值继续尝试，
                    //因此回溯后，break剪枝减少搜索空间;
                    //Money的参数index用于去除重复的解
                    if(!Money(sum,money,left,i,nums,currsum)){
                        currsum-=money[i]*j;
                        left[i]+=j;
                        break;
                    }
                    else{
                        currsum-=money[i]*j;
                        left[i]+=j;
                    }

                }
            }

        }
        if(currsum == sum) return true;
        return  false;
    }
}
