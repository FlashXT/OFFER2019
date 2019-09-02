package P05_CodeExam.C04_BeiKe;

import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/8/10 20:15
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Main3 {
    private static int min = Integer.MAX_VALUE;
    public static  void main(String [ ]args){
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int [][] nums = new int[num][3];
        for(int i = 0; i< nums.length;i++){
            nums[i][0] = scan.nextInt();
            nums[i][1] = scan.nextInt();
            nums[i][2] = scan.nextInt();
        }

        func(nums,0,0,0);
        System.out.println(min);

    }
    public static void func(int [][] nums,int index,int res,int change){
        if(index == nums.length-1){
            min = min < res ? min:res;
            return ;
        }

        if(change == 0){
            res+=nums[index][0];
            func(nums,index+1,res,0);
            res-=nums[index][0];
            res+=nums[index][1]+nums[index][2];
            func(nums,index+1,res,1);
            res-=nums[index][1]+nums[index][2];
        }
        else{
            res+=nums[index][0]+nums[index][2];
            func(nums,index+1,res,0);
            res-=nums[index][0]+nums[index][2];
            res+=nums[index][1];
            func(nums,index+1,res,1);
            res-=nums[index][1];
        }
    }
}
