import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/11,19:42
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Main2 {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        String [] str = scan.nextLine().split(" ");
        int [] nums = new int [str.length];
        for(int i = 0; i < nums.length;i++){
            nums[i] = Integer.valueOf(str[i]);
        }
        maxprofit(nums);

    }
    public static void maxprofit(int [] nums){
        if(nums.length == 0) return ;
        int res = 0;
        int oneDeal,twoDeal;
        for(twoDeal = nums.length-1; twoDeal > 0; twoDeal --){
            if(nums[twoDeal-1] < nums[twoDeal]) break;
        }
        for(oneDeal = 1; oneDeal < nums.length;oneDeal++){
            while(oneDeal +1 < nums.length && nums[oneDeal+1] >= nums[oneDeal])
                oneDeal++;
            int res1 = maxprofit(nums,0,oneDeal);
            int res2 = maxprofit(nums,oneDeal+1,twoDeal);
            if(res1+res2 > res)
                res = res1+res2;
        }
        System.out.print(res);

    }
    public static int maxprofit(int [] nums,int start,int end){
        int result = 0;
        if(end - start <1)
            return result;
        int min = nums[start];
        for(int i = start+1; i<= end;i++){
            result = Math.max(result,nums[i]-min);
            min = Math.min(min,nums[i]);
        }
        return  result;

    }
}
