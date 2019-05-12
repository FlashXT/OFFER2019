package TencentOffer.CH5.Problem30_GetLeastKNumbers;

import java.util.ArrayList;
import java.util.Arrays;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/5/12 21:57
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class GetLeastKNumbers {
    public static void main(String [] args){
        int [] arr = {2,3,4,51,2,23,323,35,565,1,24};
        ArrayList<Integer> list = GetLeastKNumbers(arr,3);
        System.out.println(Arrays.toString(list.toArray()));

    }
    public static ArrayList<Integer> GetLeastKNumbers(int [] arr,int k){
       int start = 0,end = arr.length-1;
       int index = Partition(arr,start,end);
       while(index != k-1){
           if(index < k-1){
               index = Partition(arr,index+1,end);
           }
           else
               index = Partition(arr,index,index-1);
        }
       ArrayList<Integer> list = new ArrayList<>();
       for(int i = 0;i < k;i++){
           list.add(arr[i]);
       }
       return list;

    }
    public static int Partition(int [] arr,int start,int end){
        if(arr.length == 0|| start > end) return -1;
        int provit = arr[start];
        int less = start-1;
        for(int i = start; i<= end;i++){
            if(arr[i] < provit){
                swap(arr,i,++less);
            }
        }
        return less+1;
    }
    public static void swap(int [] arr,int index,int index2){
        int temp = arr[index];
        arr[index] = arr[index2];
        arr[index2] = temp;
    }
}
