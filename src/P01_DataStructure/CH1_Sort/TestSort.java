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
        int [] arr = {12,34,53,27,45,76,89,10,61};
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
        int pivot = partation3(arr,start,end);
        QuickSort(arr,start,pivot-1);
        QuickSort(arr,pivot+1,end);

    }
    public static int partation(int [] arr,int start,int end){
        int pivot = start;
        while(start < end){
            while(start<end && arr[end] > arr[pivot])
                end --;
            swap(arr,pivot,end);
            pivot = end;

            while(start<end && arr[start]< arr[pivot])
                start++;
            swap(arr,pivot,start);
            pivot = start;
        }
        return pivot;
    }
    public static int partation2(int [] arr,int start,int end){
        //pivot = arr[start] 与moreBorder 相搭配
        int pivot = arr[start];
        int moreBorder = end+1;
        int i = end;
        while(i >= start){
            // arr[i] == pivot 再交换一次，将pivot放到正确的位置上
            if(arr[i] >= pivot){
                swap(arr,--moreBorder,i);
            }
            i--;
        }
        return moreBorder;
    }
    public static int partation3(int [] arr,int start,int end){
        //pivot = arr[end] 与lessBorder 相搭配
        int pivot = arr[end];
        int lessBorder = start-1;
        int i = start;
        while(i <= end){
            // arr[i] == pivot 再交换一次，将pivot放到正确的位置上
            if(arr[i] <= pivot){
                swap(arr,++lessBorder,i);
            }
            i++;
        }
        return lessBorder;
    }
    public static void swap(int [] arr,int index1,int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
