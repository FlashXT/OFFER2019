package SortAlgorithm.QuickSort;

import java.util.Arrays;

public class FlagOfNetherland {
    public static void main(String [] args){

        int [] arr = {1,2,4,38,34,4,4,4,75,54,9,4};
        Quicksort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    //swap
    public static void swap(int [] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //快速排序
    public static void Quicksort(int [] arr,int start, int end){
        if(start >= end) return ;
        int []  border = partitionBorder(arr,start,end);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(border));

    }

    public static int[] partitionBorder(int [] arr,int start,int end){

        int pivot = arr[end];               //初始枢轴选择输入数组的最后一个元素
        int lessBorder = start - 1;         //初始小于pivot的数字的边界在0元素之前；
        int moreBorder = end + 1;
        int i = start;
        while(i < moreBorder){
            if(arr[i] < pivot){

                swap(arr,++lessBorder,i);
                i++;

            }
            else if(arr[i] == pivot){
                i++;
            }
            else{
                swap(arr,--moreBorder,i);
            }

        }

        return new int[]{lessBorder+1,moreBorder-1};
    }
}