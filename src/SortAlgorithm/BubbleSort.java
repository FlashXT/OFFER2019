package SortAlgorithm;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String [] args){
        int [] arr = {12,10,38,42,75,68,54,9,40};
        BubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //冒泡排序
    public static void BubbleSort(int [] arr){
        if(arr == null || arr.length < 2) return ;
        int temp = 0;
        for(int i = 1; i < arr.length; i ++){
            for(int j = 0; j < arr.length - i ;j++){
                if (arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }

    }

    //swap
    public static void swap(int [] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
