package SortAlgorithm;

import java.util.Arrays;

public class InsertSort {
    public static void main(String [] args){
        int [] arr = {12,10,38,42,75,68,54,9,40};
        InsertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //插入排序
    public static void InsertSort(int [] arr){
        if(arr == null || arr.length < 2) return ;
        int temp = 0;
        for(int i = 1; i < arr.length; i ++){

            for(int j = i; j > 0 ;j--){
                if(arr[j] < arr[j-1]){
                    swap(arr,j-1,j);
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
