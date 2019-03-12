package SortAlgorithm;

import java.util.Arrays;
/********************************************************************************
 * 选择排序法:选择排序的思想是第一个元素起，依次找到第i大的数放入第(n-i)个位置；
 *
 * 选择排序时间复杂度为O(n^2),空间复杂度O(1),是不稳定的排序算法；
 * 复杂度分析：
 *
 *      ①比较操作：(n-1)+(n-2)+...+1 = n(n-1)/2,O(n^2);
 *      ②交换操作：O(1)
 *      ③空间复杂度：O(1)
 *      ④时间复杂度:O(n^2)
 *
 * Author:FlashXT;
 * Date:2019.3.12,Tuesday;
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************************/
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
