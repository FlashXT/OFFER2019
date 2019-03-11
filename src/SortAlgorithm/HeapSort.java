package SortAlgorithm;

import java.util.Arrays;

public class HeapSort {
    public static void main(String [] args){
        int [] arr = {12,34,45,23,56,78,22};
        System.out.println(Arrays.toString(arr));
        HeapSort(arr);
        System.out.println(Arrays.toString(arr));

    }
    public static void HeapSort(int [] arr ){
        HeapBulid(arr,0,arr.length-1);
        for(int i = arr.length-1; i >0;i--){
            swap(arr,0,i);
            HeapBulid(arr,0,i-1);
        }

    }

    public static void HeapBulid(int [] arr,int start,int end){
        //建立大顶堆
        int temp = 0;
        for(int i = start; 2*i+2<= end;i++){
            temp = 2*i+1;
            while(i >= 0){
                if(arr[i]>arr[2*i+1] && arr[i] > arr[2*i+2])
                    break;
                int index = arr[temp] > arr[temp+1] ? temp:temp+1;
                if(arr[index] > arr[i]){
                    swap(arr,index,i);
                    //i = (i - 3)/2;
                    i = (temp-3)/4;
                    temp = 2*i+1;
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
