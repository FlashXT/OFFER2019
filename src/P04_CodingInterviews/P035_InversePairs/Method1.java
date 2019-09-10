package P04_CodingInterviews.P035_InversePairs;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/10 22:50
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    static long res = 0;
    public int InversePairs(int [] array) {
        res = 0;
        MergeSort(array,0,array.length-1);
        System.out.println(res);
        return (int)(res%1000000007);

    }
    public static void MergeSort(int [] arr,int start,int end){
        if(start >= end) return;
        int mid = start+(end - start)/2;
        MergeSort(arr,start,mid);
        MergeSort(arr,mid+1,end);
        Merge(arr,start,mid,end);

    }
    public static void Merge(int [] arr,int start,int mid, int end){
        int ptr1 = start;
        int ptr2 = mid+1;
        int [] temp = new int [end-start+1];
        int i = 0;
        while(ptr1 <= mid && ptr2 <=end){
            if(arr[ptr1] <= arr[ptr2]){
                temp[i++]= arr[ptr1++];
            }
            if(arr[ptr1] > arr[ptr2]){
                res+= mid - ptr1+1;
                temp[i++] = arr[ptr2++];
            }
        }
        while(ptr1<=mid)temp[i++] = arr[ptr1++];
        while(ptr2<=end)temp[i++] = arr[ptr2++];
        for(int j = 0 ;j < temp.length;j++){
            arr[start+j] = temp[j];
        }
    }
}
