package TencentOffer.CH6.Problem46_JosephCircle;

import java.util.ArrayList;
import java.util.Arrays;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/5/15 20:47
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Problem46_JosephCircle {
    public static void main(String [] args){

        System.out.println(JosephCircle(5,3));
    }
    public static int JosephCircle(int n,int m){
        if(n <1 || m < 1) return -1;
        int [] nums = new int [n];
        int i = 0,j= 0,index = 0;
        while(i< nums.length){
            index = j;
            for( ; j <index+m;j++){
                if(nums[j%nums.length] == -1){
                    index++;
                }
            }
            j--;
            nums[j%nums.length] = -1;

            i++;
        }
        return j%nums.length;
    }
}
