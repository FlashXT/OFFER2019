package P05_CompanyCodeExam.MeiTuan;

import java.util.Arrays;
import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/8/31 20:04
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Problem2 {
    //优化方法O(nlogn)
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] arr = new int[n];
        int [] temp = new int[n];
        for(int i = 0; i < n;i++){
            arr[i] = scan.nextInt();
            temp[i] = arr[i];
        }

        Arrays.sort(temp);
        int [] sum = new int[n];
        for(int i = 0; i<n;i++){
            int index = BinarySearch(temp,arr[i]);
            sum[i] = getsum(temp,index);
        }
        System.out.println(Arrays.toString(sum));

    }
    public static int BinarySearch(int [] arr,int target){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start+(end - start)/2;
            if(arr[mid] == target){
                while(mid >= 1 && arr[mid-1] == arr[mid])
                    mid--;
                return mid;
            }
            else if(arr[start] < target)
                start = mid+1;
            else
                end = mid-1;
        }
        return -1;
    }
    public static int getsum(int [] arr,int index){
        int sum = 0;
        for(int i = 0; i < index;i++)
            sum+=arr[i];
        return sum;
    }

    //暴力方法O(n^2)
    public static void getsum(int [] arr){
        int [] sum = new int [arr.length];
        for(int i = 0 ;i < arr.length;i++){
            for(int j = 0 ; j < arr.length;j++){
                if(arr[j] < arr[i])
                    sum[i]+=arr[j];
            }
        }
        System.out.println(Arrays.toString(sum));
    }
}
