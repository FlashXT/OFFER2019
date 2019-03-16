package CH1_SortAlgorithm.HeapSort;

import java.util.Arrays;
/************************************************************************************
 * 堆排序过程:
 *  ①将初始待排序关键字序列(R1,R2....Rn)构建成大顶堆，此堆为初始的无序区；
 *  ②将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,......Rn-1)和新的有序区(Rn)
 *  ③由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,......Rn-1)调整为新堆；
 *  ④然后再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1,R2....Rn-2)和新的有序区(Rn-1,Rn)。
 *  不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。
 *
 * 建立堆的时间复杂度为log1+log2+...+logn ~ O(n),堆调整的时间复杂度为O(nlogn);
 * 堆排序时间复杂度为O(nlog(n)),空间复杂度为O(1),不稳定的排序算法；
 *
 * 应用：堆
 * Author:FlashXT;
 * Date:2019.3.11,Monday;
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************************/


public class HeapSort {
    public static void main(String [] args){
        int [] arr = {46,79,56,38,40,84};
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
        //建立大顶堆,标准方法，从堆底开始建立堆
        int index = 0;
        for(int i = end/2; i >= 0; i-- ){
            index = i*2+1;
            while(index <= end){
                //确定右孩子是否存在,以及左右孩子中的最大值
                int largest =index < end && arr[index] < arr[index+1] ? index+1:index;
                //如果满足堆的条件，则跳出循环；
                if( arr[i]>arr[largest])
                    break;
                //如果当前子堆进行了交换，那么需要对以该子堆为顶所在的子堆进
                // 行检查是否需要调整，重复此过程直到堆顶；
                if(arr[largest] > arr[i]){
                    swap(arr,largest,i);
                    i = largest;
                    index = i*2+1;
                }
            }
        }
    }

    public static void HeapBulid2(int [] arr,int start,int end){
        //建立大顶堆，了解方法，从堆顶开始建立堆
        int temp = 0;
        for(int i = start; i <= (end +1)/2-1;i++){

            while(i >= 0){
                temp = 2*i+1;
                //确定右孩子是否存在,以及左右孩子中的最大值
                int index =temp < end && arr[temp] < arr[temp+1] ? temp+1:temp;
                //如果满足堆的条件，则跳出循环；
                if(arr[i]>arr[index])
                    break;

                //如果当前子堆进行了交换，那么需要对该子堆顶所在的子堆进
                // 行检查是否需要调整，重复此过程直到堆顶；
                if(arr[index] > arr[i]){
                    swap(arr,index,i);
                    i = (i - 3)/2;
//                    i = (temp-3)/4;
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
