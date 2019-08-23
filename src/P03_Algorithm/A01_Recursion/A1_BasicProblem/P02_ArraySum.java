package P03_Algorithm.A01_Recursion.A1_BasicProblem;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/8/20,10:55
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class P02_ArraySum {
    public static void main(String [] args){
        int [] nums = {1,2,3,4,5,6,7,8,9,10};
        int res1 = arrSum1(nums,0);
        int res2 = arrSum2(nums,0,0);
        int res3 = arrSumBin(nums,0,nums.length-1);
        System.out.println(res1+"\t"+res2+"\t"+res3);
    }
    public static int arrSum1(int [] arr,int index){
        if (index == arr.length){
            return 0;
        }
        return arr[index]+arrSum1(arr,index+1);
    }
    public static int arrSum2(int [] arr,int index,int res){
        if (index == arr.length){
            return res;
        }
        return arrSum2(arr,index+1,res+arr[index]);
    }
    public static int arrSumBin(int [] arr,int start,int end){
        if (start == end){
            return arr[start];
        }
        int mid = start + (end - start)/2;
        return arrSumBin(arr,start,mid)+arrSumBin(arr,mid+1,end);
    }
}
