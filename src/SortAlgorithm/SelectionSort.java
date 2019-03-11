package SortAlgorithm;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String [] args){
        int [] arr = {12,10,38,42,75,68,54,9,40};
        SelectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //选择排序
    public static void SelectionSort(int [] arr){
        if(arr == null || arr.length < 2) return ;
        int index = 0;
        for(int i = 0; i < arr.length; i ++){
            index = i;
            for(int j = i+1; j < arr.length ;j++){
                if(arr[j] < arr[index]){
                    index = j;
                }
            }
            swap(arr,i,index);
        }
    }

    //swap
    public static void swap(int [] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
