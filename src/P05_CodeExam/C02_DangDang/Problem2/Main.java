package P05_CodeExam.C02_DangDang.Problem2;
import java.util.Arrays;
import java.util.Scanner;
/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/2,18:47
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/

public class Main {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        String[] strarr = scan.next().split(",");

        sortColors(strarr);
    }
    public static void sortColors(String [] nums) {
        if(nums.length <= 1) {
            System.out.println(nums[0]);
            return ;
        }
        int left = -1;
        int right = nums.length;

        for(int i = 0; i< right;i++){
            if(Integer.valueOf(nums[i]) > 1)
                swap(nums,i--,--right);

            else if(Integer.valueOf(nums[i]) < 1)
                swap(nums,i,++left);
        }

        int k = 0;
        for(; k< nums.length-1;k++)
            System.out.print(nums[k]+",");
        System.out.print(nums[k]);
    }
    public static  void swap(String []nums,int i,int j){
        String temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
