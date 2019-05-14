package Algorithm.DynamicProgramming.DP07_LongestIncreasingSubsequence;

import java.util.Arrays;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/5/13 22:38
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class LongestIncreasingSubsequence1 {
    public static void main(String [] args){
        int [] arr = {10,9,2,5,3,7,101,18};
        System.out.println( LIS(arr));
    }
    public static int  LIS(int [] arr){
        if(arr.length ==0) return 0;
        int []len = new int[arr.length];
        for(int i =0;i < len.length;i++)
            len[i]  =1;
        LIS(arr,arr.length-1,len);
        Arrays.sort(len);
        return len[len.length-1];

    }
    //递归
    private static void LIS(int [] arr,int index,int []len){
        if(index ==0)
            return ;
        LIS(arr,index-1,len);
        for(int j = index-1; j >=0;j--){
            if(arr[index] > arr[j]){
                len[index] = len[index] > len[j]+1?len[index]:len[j]+1;
            }
        }
    }
}
