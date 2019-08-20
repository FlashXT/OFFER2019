package P03_Algorithm.A03_DynamicProgramming.DP07_LongestIncreasingSubsequence;

import java.util.Arrays;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/5/13 22:38
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class LongestIncreasingSubsequence2DP {
    public static void main(String [] args){
        int [] arr = {10,9,2,5,3,7,101,18};
        System.out.println( LIS(arr));
    }

    //动态规划
    private static int LIS(int [] arr){
        int [] len = new int[arr.length];
//        for(int i = 0; i < len.length;i++)
//            len[i] = 1;
        for(int i = 0; i< arr.length;i++){
            len[i] = 1;
            for(int j = i-1; j >=0;j--){
                if(arr[i] > arr[j]){
                    len[i] = len[i] > len[j]+1?len[i]:len[j]+1;
                }
            }
        }
        Arrays.sort(len);
        return len[len.length-1];

    }

}
