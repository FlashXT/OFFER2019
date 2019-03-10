package SortAlgorithm;
import java.util.*;
public class SortAlgorithm {
    public static void main(String[]args){
        int [] arr = {12,10,38,42,75,68,54,9,40};

//        System.out.println(Arrays.toString(BubbleSort(arr)));
//        System.out.println(Arrays.toString(InsertSort(arr)));
//        System.out.println(Arrays.toString(SelectSort(arr)));
//        MergeSort(arr,0,arr.length-1);
//        System.out.println(Arrays.toString(arr));
        Quicksort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
//        int index = partitionBorder(arr,0,arr.length-1);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(index);

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

    //快速排序
    public static void Quicksort(int [] arr,int start, int end){
        if(start >= end) return ;
//        int pivot = partitionBorder(arr,start,end);
        int pivot = partition(arr,start,end);
        Quicksort(arr,start,pivot-1);
        Quicksort(arr,pivot+1,end);

    }

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



}
