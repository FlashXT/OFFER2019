package TencentOffer.CH5;

import TencentOffer.CH5.Problem34_GetUglyNumber.GetUglyNumber;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/5/14 21:46
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Problem38_GetNumberOfK {
    public static void main(String [] args){
        int [] arr = {1,2,3,3,3,3};
        System.out.println(GetNumberOfK(arr,3));
    }
    public static int GetNumberOfK(int[] arr,int k){
        if(arr.length == 0) return 0;
        int first =GetFirstK(arr,k,0,arr.length-1);
        int last =GetLastK(arr,k,0,arr.length-1);
        if(first != -1 && last != -1)
            return last-first+1;
        return 0;


    }
    public static int GetFirstK(int [] arr,int k,int start,int end){
        if(start > end) return -1;
        int mid = start +(end - start)/2;
        if(arr[mid] == k){
            if(mid > 0 &&arr[mid-1] !=k || mid == 0)
                return mid;
            else
                end = mid-1;
        }
        else if(arr[mid] > k)
            end = mid - 1;
        else
            start = mid +1;
        return GetFirstK(arr,k,start,end);
    }
    public static int GetLastK(int [] arr,int k,int start,int end){
        if(start > end) return -1;
        int mid = start +(end - start)/2;
        if(arr[mid] == k){
            if(mid < arr.length-1 &&arr[mid+1] !=k || mid == arr.length-1)
                return mid;
            else
                start= mid+1;
        }
        else if(arr[mid] > k)
            end = mid - 1;
        else
            start = mid +1;
        return GetLastK(arr,k,start,end);
    }
}
