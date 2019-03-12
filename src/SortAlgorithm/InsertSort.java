package SortAlgorithm;

import java.util.Arrays;

/********************************************************************************
 * 插入排序法:插入排序的思想是在处理第i个数时，前面的(i-1)个数已经有序，将第i个数插入到这(i-1)
 * 个数的正确位置上，直到第n个数为止；
 *
 * 插入排序是稳定的排序算法；折半插入排序是不稳定的排序算法；
 *
 * 复杂度分析：
 * 1.最好情况(原数组顺序):
 *      ①比较操作：(n-1);
 *      ②交换操作：0
 *      ③空间复杂度：0
 *      ④时间复杂度:O(n)
 * 2.最坏情况（原数组逆序）：
 *      ①比较操作：1+2+...+(n-1)=(n-1)*n/2,O(n^2);
 *      ②交换操作：1+2+...+(n-1)=(n-1)*n/2,O(n^2);
 *      ③空间复杂度：O(1)
 *      ④时间复杂度:O(n^2)
 *
 * 改进：在确定第i个数插入到(i-1)个有序数的位置时，由于前(i-1)个数有序，采用二分查找法确定第i个数
 *      的位置；此时插入排序的事件复杂度为O(nlog(n)).
 * Author:FlashXT;
 * Date:2019.3.12,Tuesday;
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************************/
public class InsertSort {
    public static void main(String [] args){
        int [] arr = {12,10,38,42,75,68,54,54,9,40};
//        InsertSort(arr);
        BinaryInsertSort(arr);
        System.out.println(Arrays.toString(arr));


    }
    //插入排序
    public static void InsertSort(int [] arr){
        if(arr == null || arr.length < 2) return ;
        //i从1开始表示第一个数已经有序
        for(int i = 1; i < arr.length; i ++){
            if(arr[i] < arr[i-1]){
                for(int j = i; j > 0 ;j--){
                    if(arr[j] < arr[j-1]){
                        swap(arr,j-1,j);
                    }
                }
            }

        }

    }

    //二分插入排序
    public static void BinaryInsertSort(int [] arr){
        if(arr == null || arr.length < 2) return ;
        int temp = 0;
        //i从1开始表示第一个数已经有序
        for(int i = 1; i < arr.length; i ++){
            if(arr[i] < arr[i-1]){
                int pos = BinarySearch(arr,0,i-1,arr[i]);
//                System.out.println("arr["+i+"]="+arr[i]+",\tpos = "+pos);
                for(int j = i; j > pos ;j--){
                        swap(arr,j-1,j);

                }
            }
//            System.out.println(Arrays.toString(arr));
        }

    }

    public static int BinarySearch(int [] arr,int start ,int end,int key){
        if( start > end ) return 0;
        int mid = start + (end - start)/2;
        if(arr[mid] <= key && arr[mid+1] >= key) return mid+1;
        else if( arr[mid] > key)
            return BinarySearch(arr,start,mid-1,key);
        else
            return BinarySearch(arr,mid+1,end,key);

    }






    //swap
    public static void swap(int [] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
