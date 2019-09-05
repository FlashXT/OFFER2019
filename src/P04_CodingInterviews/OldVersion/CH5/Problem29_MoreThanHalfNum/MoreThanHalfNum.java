package P04_CodingInterviews.OldVersion.CH5.Problem29_MoreThanHalfNum;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/5/12 19:52
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class MoreThanHalfNum {
    public static void main(String [] args){
        int [] arr = {1,2,3,4,5,2,2,2,2,2};
        System.out.println(MoreThanHalfNum(arr));
    }
    public static int MoreThanHalfNum(int [] arr) {
        if(arr.length == 0) return 0;
        int index = Partition(arr,0,arr.length-1);
        int middle = arr.length/2;
        while(index != middle){
            if(index < middle)
                index = Partition(arr,index+1,arr.length-1);
            else
                index = Partition(arr,0,index-1);

        }
        int times = 0;
        for(int i =0 ; i<arr.length;i++){
            if(arr[i] == arr[middle])
                times++;
        }
        if(times > arr.length/2)
            return arr[middle];
        return 0;

    }
    public static int Partition(int [] arr,int start,int end){
        int provit = arr[start];
        if(start > end) return -1;
        int less = start -1;
        for(int i = start;i <=end ;i++){
            if(arr[i] < provit){
                swap(arr,i,++less);
            }
        }
        return ++less;
    }
    public static void swap(int [] arr,int index,int index2){
        int temp = arr[index];
        arr[index] = arr[index2];
        arr[index2] = temp;
    }
}
