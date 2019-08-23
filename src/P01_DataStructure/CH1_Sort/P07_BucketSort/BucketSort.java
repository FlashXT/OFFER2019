package P01_DataStructure.CH1_Sort.P07_BucketSort;
/***********************************************************
 * 时间复杂度可以达到O(n),但是受数据影响，主要体会桶的思想；
 ***********************************************************/

import java.util.Arrays;

public class BucketSort {

    public static void main(String [] args){
            int arr [] = {12,10,38,42,75,68,54,9,40};
            countSort(arr);
            System.out.println(Arrays.toString(arr));
    }
    //计数排序
    public static void CountSort(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length;i++)
            max = max < arr[i]? arr[i]:max;
        int [] bucket = new int[max+1];
        for(int i = 0; i < arr.length;i++)
            bucket[arr[i]]++;
        int i = 0;
        for(int j = 0; j < bucket.length;j++)
            while(bucket[j]-- > 0)
                    arr[i++] = j;

    }
    //计数排序优化
    public static void countSort(int[]arr){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length;i++){
            max = max < arr[i]? arr[i]:max;
            min = min > arr[i]? arr[i]:min;
        }

        int [] bucket = new int[max-min+1];
        for(int i = 0; i < arr.length;i++)
            bucket[arr[i]-min]++;
        int i = 0;
        for(int j = 0; j < bucket.length;j++)
            while(bucket[j]-- > 0)
                arr[i++] = j+min;

    }
}
