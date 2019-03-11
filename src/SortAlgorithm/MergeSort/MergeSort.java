package SortAlgorithm.MergeSort;
import java.util.*;
public class MergeSort {
    public static void main(String[]args){
        int [] arr = {12,10,38,42,75,68,54,9,40};

        MergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));


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
