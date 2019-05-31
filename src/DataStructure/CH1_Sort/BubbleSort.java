package DataStructure.CH1_Sort;

import java.util.Arrays;

/****************************************************************************
 * 冒泡排序法:冒泡排序法，也叫相邻比序法，具体流程为相邻位置上的数进行比较，如果左边的
 * 数比右边的数大，则交换；直到最后一个数的位置；这样一趟交换可以确定一个数的位置，（第一
 * 趟确定最大数的位置，第二趟确定第二大数的位置，以此类推），一共需要进行(n-1)趟排序；
 *
 * 冒泡排序时间复杂度为O(n^2),空间复杂度为O(1),是稳定的排序算法；
 *
 * 复杂度分析：
 * 1.最好情况(原数组顺序):
 *      ①比较操作：(n-1)+(n-2)+...+1=(n-1)*n/2,O(n^2);
 *      ②交换操作：0
 *      ③空间复杂度：0
 *      ④时间复杂度:O(n)
 * 2.最坏情况（原数组逆序）：
 *      ①比较操作：(n-1)+(n-2)+...+1=(n-1)*n/2,O(n^2);
 *      ②交换操作：(n-1)+(n-2)+...+1=(n-1)*n/2,O(n^2);
 *      ③空间复杂度：O(1)
 *      ④时间复杂度:O(n^2)
 * Author:FlashXT;
 * Date:2019.3.11,Monday;
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************************/
public class BubbleSort {
    public static void main(String [] args){
        int [] arr = {12,10,38,42,75,68,54,9,40};
        BubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //冒泡排序
    public static void BubbleSort(int [] arr){
        if(arr == null || arr.length < 2) return ;

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
