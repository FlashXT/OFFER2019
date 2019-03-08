package SortAlgorithm;
import java.util.*;
public class SortAlgorithm {
    public static void main(String[]args){
        int [] arr = {12,34,56,45,67,45,89,30};

//        System.out.println(Arrays.toString(BubbleSort(arr)));
//        System.out.println(Arrays.toString(InsertSort(arr)));
//        System.out.println(Arrays.toString(SelectSort(arr)));
//        MergeSort(arr,0,arr.length-1);
//        System.out.println(Arrays.toString(arr));
    }

    //swap
    public static void swap(int [] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //冒泡排序
    public static int[] BubbleSort(int [] arr){
        int temp = 0;
        for(int i = 1; i < arr.length; i ++){
            for(int j = 0; j < arr.length - i ;j++){
                if (arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
        return arr;
    }
    //插入排序
    public static int[] InsertSort(int [] arr){
        int temp = 0;
        for(int i = 1; i < arr.length; i ++){

            for(int j = i; j > 0 ;j--){
                if(arr[j] < arr[j-1]){
                    swap(arr,j-1,j);
                }
            }
        }
        return arr;
    }
    //选择排序
    public static int[] SelectSort(int [] arr){
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
        return arr;
    }

    //归并排序
    public static void MergeSort(int [] arr,int start,int end){
        if( start == end) return ;
        int mid = start +(end - start)/2;
        MergeSort(arr,start,mid);
        MergeSort(arr,mid+1,end);
        merge(arr,start,mid,end);
    }

    public static void merge(int []arr,int start,int mid,int end){
        int i = start;
        int j = mid+1;
        int k =0;
        int [] temp = new int[end-start+1];
        while(i <= mid && j <= end){
            if(arr[i] < arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        while(j <= end)
            temp[k++] = arr[j++];

        while(i <= mid)
            temp[k++] = arr[i++];

        for(i = 0 ;i <temp.length; i++)
            arr[start + i] = temp[i];
    }




}
