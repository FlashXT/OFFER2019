package CH1_SortAlgorithm.MergeSort;
import java.util.*;

/******************************************************************************
 * 归并排序法: 归并排序思想是将两个有序表，合并为一个有序表，将初始序列看成n个有序子序列（每
 * 个子序列只含一个元素），然后两两归并，得到ceil(n/2)个长度为2或1的子序列，再两两归并，...
 * ,直到得到一个长度为n的有序序列为止，这种方法叫做2路归并排序；
 *
 * 归并排序时间复杂度为O(nlog(n)),空间复杂度为O(n)稳定的排序算法；
 * 估计一个算法流程的复杂度，需要对流程的细节彻底知晓，但是对于递归函数，有一个重要内容：
 * Master公式:
 *                      T(N) = aT(N/b) + N^d
 *
 *          ①   log(b,a) > d -> T(N) ,复杂度为 N^(log(b,a))
 *          ②   log(b,a) == d -> T(N),复杂度为 N^d * logN
 *          ③   log(b,a) < d -> T(N) ,复杂度为 N^d
 *        这是一个估计递归行为复杂度的公式，但是要求递归行为中，每次递归的规模是固定的。
 *拓展：http://www.gocalf.com/blog/algorithm-complexity-and-master-theorem.html
 * 应用 ： 求小和问题，逆序对问题
 * Author:FlashXT;
 * Date:2019.3.11,Monday;
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************************/
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
