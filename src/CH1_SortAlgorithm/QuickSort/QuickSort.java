package CH1_SortAlgorithm.QuickSort;

import java.util.Arrays;
/****************************************************************************
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
 *****************************************************************************/
public class QuickSort {


    public static void main(String [] args){
        int [] arr = {12,10,38,42,75,68,54,9,40};
        Quicksort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    //快速排序
    public static void Quicksort(int [] arr,int start, int end){
        if(start >= end) return ;
        //随机选择枢轴,默认第一个元素为枢轴
        swap(arr,start+(int)(Math.random()*(end-start)),start);
//        int pivot = partitionBorder(arr,start,end);   //边界法计算枢轴位置
//        int pivot = partition(arr,start,end);         //经典方法计算枢轴位置

//        Quicksort(arr,start,pivot-1);
//        Quicksort(arr,pivot+1,end);

        int[] pivot = partitionFlag(arr,start,end);     //荷兰国旗法计算枢轴位置
        Quicksort(arr,start,pivot[0]-1);
        Quicksort(arr,pivot[1]+1,end);


    }

    //经典方法
    public static int partition(int [] arr,int start,int end){
        int pivot = start;
        int low = start;
        int high = end;
        while(low < high){
            if(arr[low] > arr[pivot]){
                swap(arr,low,pivot);
                pivot = low;
            }
            if(arr[high] < arr[pivot]){
                swap(arr,high,pivot);
                pivot = high;
            }
            low++;
            high--;
        }
        return pivot;
    }

    //边界法
    public static int partitionBorder(int [] arr,int start,int end){

        int pivot = arr[end];               //初始枢轴选择输入数组的最后一个元素
        int lessBorder = start - 1;         //初始小于pivot的数字的边界在0元素之前；
        int i = start;
        while(i<= end){
            if(arr[i] <= pivot){  //“=”是将枢轴元素移动到lessBroder处,返回正确的lessBorder；
                //遍历数组将小于等于枢轴元素的值与边界的位置的值进行交换，边界向右增1；

                swap(arr,++lessBorder,i);

            }
            i++;
        }
        return lessBorder;
    }
    //荷兰国旗法
    public static int[] partitionFlag(int[] arr, int start, int end) {
        int pivot = arr[start];
        int less = start - 1;
        int more = end + 1;
        while (start < more) {
            if (arr[start] < pivot) {
                swap(arr, ++less, start++);
            } else if (arr[start] > pivot) {
                swap(arr, --more, start);
            } else {
                start++;
            }
        }
        return new int[] { less + 1, more - 1 };
    }



    //swap
    public static void swap(int [] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
