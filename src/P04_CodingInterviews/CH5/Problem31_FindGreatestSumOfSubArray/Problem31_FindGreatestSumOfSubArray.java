package P04_CodingInterviews.CH5.Problem31_FindGreatestSumOfSubArray;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/13 9:40;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Problem31_FindGreatestSumOfSubArray {
    private static int ss = Integer.MIN_VALUE;
    public static void main(String [] args){
        int [] arr = {2,8,1,5,9};

        System.out.println(FindGreatestSumOfSubArray(arr));
    }
    public static int FindGreatestSumOfSubArray(int [] arr){
        FindGreatestSumOfSubArray(arr,arr.length-1,0);
        int res = ss;
        ss = Integer.MIN_VALUE;
        return res;

    }
    private static int FindGreatestSumOfSubArray(int [] arr,int index,int sum){
        if(index < 0)
            return 0;

        int temp  = FindGreatestSumOfSubArray(arr,index-1,sum);

        if(temp >0){
            sum = arr[index]+temp;
        }
        else{
            sum = arr[index];
        }
        ss = sum>ss?sum:ss;
        return ss;
    }
}
