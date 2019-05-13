package Algorithm.DynamicProgramming.DP07_LongestIncreasingSubsequence;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/5/13 22:38
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class LongestIncreasingSubsequence {
    public static void main(String [] args){
        int [] arr = {10,9,2,5,3,7,101,18};
        System.out.println(LIS(arr,0,1));
    }
    //递归
    public static int LIS(int [] arr,int index,int len){
        if(index+1 == arr.length){
            return len;}
        if(arr[index+1] > arr[index]){
            len++;
            LIS(arr,index+1,len);
        }
        else{
            LIS(arr,index+1,len);
        }
        return len;
    }
}
