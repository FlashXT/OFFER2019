package TencentOffer.CH5.Problem31_FindGreatestSumOfSubArray;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/13 9:40;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Problem31_FindGreatestSumOfSubArrayDP {
    private static int ss = Integer.MIN_VALUE;
    public static void main(String [] args){
        int [] arr = {2,8,1,5,9};

        System.out.println(FindGreatestSumOfSubArray(arr));
    }
    public static int FindGreatestSumOfSubArray(int [] arr){
        int res = arr[0];
        int[] sum = new int [arr.length];
        sum[0] = arr[0];
        for(int i =0;i < arr.length-1;i++){
            if(sum[i] > 0){
                sum[i+1] = arr[i+1]+sum[i];
            }
            else{
                sum[i+1] = arr[i+1];
            }
            res = sum[i+1]>res?sum[i+1]:res;
        }
        return res;

    }

}
