package SortAlgorithm.QuickSort;

import java.util.Arrays;

public class QuickSort {


    public static void main(String [] args){
        int [] arr = {12,10,38,42,75,68,54,9,40};
        Quicksort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
//        int index = partitionBorder(arr,0,arr.length-1);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(index);
    }

    //快速排序
    public static void Quicksort(int [] arr,int start, int end){
        if(start >= end) return ;
        //随机选择枢轴,默认第一个元素为枢轴
        swap(arr,start+(int)(Math.random()*(end-start)),start);
//        int pivot = partitionBorder(arr,start,end); //边界法计算枢轴位置
//        int pivot = partition(arr,start,end);
//        Quicksort(arr,start,pivot-1);
//        Quicksort(arr,pivot+1,end);

        int[] pivot = partitionFlag(arr,start,end);

        Quicksort(arr,start,pivot[0]-1);
        Quicksort(arr,pivot[1]+1,end);


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

    //swap
    public static void swap(int [] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
