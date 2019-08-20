package P01_DataStructure.CH1_Sort.MergeSort;

/********************************************************************************
 * 例如：数组[4,2,5,1,7,3,6]
 * 逆序对：[4,2],[4,1],[5,1],[4,3];
 *        [2,1],[5,1],[5,3],[7,3];
 *
 * 逆序对:使用归并排序，左边1/2数组的逆序对+右边1/2数组的逆序对 ，然后加上组间逆序对；
 * 组间逆序对：如果那么就是右边比左边小，那么从中间位置mid到左下标P1共有(mid-P1+1)个逆序对。
 *
 ********************************************************************************/

public class ReversePair {
    public static void main(String [] args){
        int [] arr ={4,2,5,1,7,3,6};
        int pair= MergeSort(arr,0,arr.length-1);
        System.out.println(pair);
    }

    public static int MergeSort(int[] arr,int start,int end){
        if(start >= end) return 0;
        int mid = start+(end - start)/2;
        int pair1 =  MergeSort(arr,start,mid);
        int pair2 =  MergeSort(arr,mid+1,end);
        return pair1 + pair2 + Merge(arr,start,mid,end);
    }
    public static int Merge(int []arr,int start,int mid,int end){

        int i = start;
        int j = mid+1;
        int k = 0;
        int pair = 0;
        int [] temp = new int[end-start+1];
        while(i <= mid && j <=end){
            if(arr[i] > arr[j]){
                pair = pair+(mid-i+1);
                temp[k++] = arr[j++];
            }
            else{
                temp[k++] = arr[i++];
            }
        }
        while(i <= mid){
            temp[k++]=arr[i++];
        }
        while(j <= end){
            temp[k++]=arr[j++];
        }
        for(i = 0; i < temp.length;i++)
            arr[start+i] = temp[i];
        return pair;
    }

}