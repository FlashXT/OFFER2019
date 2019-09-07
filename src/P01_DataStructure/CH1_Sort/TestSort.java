package P01_DataStructure.CH1_Sort;

import java.util.Arrays;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/7 18:15
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class TestSort {
    public static void main(String [] args){
        int [] arr = {13,22,43,53,45,34,78,86,100,99,101};
//        bubbleSort(arr);
//        insertSort(arr);
//        MergeSort(arr,0,arr.length-1);
//        System.out.println(Arrays.toString(arr));
        QuickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
    public static void bubbleSort(int [] arr){
        if(arr == null ||arr.length < 2) return ;
        for(int i = arr.length;i >=0;i--){
            boolean flag = false;
            for(int j = 1; j < i;j++){
                if(arr[j] < arr[j-1]){
                    swap(arr,j,j-1);
                    flag = true;
                }
            }
            if(!flag) break;
        }
        System.out.println(Arrays.toString(arr));

    }
    public static void insertSort(int [] arr){
        for(int i = 1; i < arr.length;i++){
            if(arr[i] < arr[i-1]){
                for(int j = i; j > 0;j--)
                    if(arr[j] < arr[j-1])
                        swap(arr,j,j-1);
            }
        }
        System.out.println(Arrays.toString(arr));

    }
    public static void MergeSort(int [ ]arr,int start,int end){
        if(start == end )return ;
        int mid = start + (end - start)/2;
        MergeSort(arr,start,mid);
        MergeSort(arr,mid+1,end);
        Merge(arr,start,mid,end);
    }
    public static void Merge(int [] arr,int start,int mid,int end){
        int [] temp = new int[end-start+1];
        int ptr1 = start,ptr2 = mid+1;
        int i = 0;
        while(ptr1 <= mid && ptr2 <= end){
            if(arr[ptr1] < arr[ptr2]){
                temp[i++] = arr[ptr1++];
            }else{
                temp[i++] = arr[ptr2++];
            }
        }
        while (ptr1 <= mid){
            temp[i++] = arr[ptr1++];
        }
        while (ptr2 <= end){
            temp[i++] = arr[ptr2++];
        }
        for(int j = 0; j < temp.length;j++){
            arr[start+j] = temp[j];
        }
    }
    public static void QuickSort(int [] arr,int start,int end){
        if(start >= end) return;
        swap( arr,start+(int)(Math.random()*(end-start)),start);
        int pivot = partation(arr,start,end);
        QuickSort(arr,start,pivot);
        QuickSort(arr,pivot,end);

    }
    public static int partation(int [] arr,int start,int end){

        int pivot = arr[start];
        int lessborder = start-1;
        int i = start+1;
        while(i <= end){
            if(arr[i] <= pivot)
                swap(arr,++lessborder,i);
            i++;

        }
        return lessborder;
    }
    public static void swap(int [] arr,int index1,int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
