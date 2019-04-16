package DataStructure.CH1_Sort.QuickSort;

import java.util.Arrays;

/******************************************************************************
 * 快速排序法:设要排序的数组是A[0]……A[N-1]，首先任意选取一个数据（通常选用数组的第一个数）
 * 作为关键数据，然后将所有比它小的数都放到它前面，所有比它大的数都放到它后面，这个过程称为一
 * 趟快速排序。然后递归进行此过程,直到该序列有序；
 *
 * 快速排序的时间复杂度为O(nlog(n)),空间复杂度为O(log(n)),不稳定的排序算法；
 *
 * 应用：荷兰国旗问题
 * Author:FlashXT;
 * Date:2019.3.11,Monday;
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *******************************************************************************/
public class QuickSort {

    public static void main(String [] args){
        int [] arr = {12,10,38,42,75,68,54,9,40};
        Quicksort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    //快速排序
    public static void Quicksort(int [] arr,int start, int end){
        if(start > end) return ;
        //随机性保证快排的效率
        swap(arr,start,start+(int)(Math.random()*(end-start)));
        int pivot = partition(arr,start,end);
        Quicksort(arr,start,pivot-1);
        Quicksort(arr,pivot+1,end);

    }

    //经典方法
    public static int partition(int [] arr,int start,int end){
        int pivot = start;
        int low = start;
        int high = end;
        while(low < high){
            //pivot等于第一个位置，所以从最后一个位置(另一端)开始
            while (low < high && arr[high] >= arr[pivot]){
                high--;
            }
            swap(arr,high,pivot);
            pivot = high;
            while (low < high && arr[low] <= arr[pivot]){
                low++;
            }
            swap(arr,low,pivot);
            pivot = low;

        }

        return pivot;
    }
    //swap
    public static void swap(int [] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
