package P04_CodingInterviews.OldVersion.CH6.Problem41_FindNumbersWithSum;

import java.util.ArrayList;
import java.util.Arrays;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/15 10:58;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Problem41_FindNumbersWithSum2 {
    public static void main(String [] args){
        int [] arr = {1,2,4,7,11,15};
        ArrayList<Integer> list = FindNumbersWithSum(arr,15);
        System.out.println(Arrays.toString(list.toArray()));
    }
    //复杂度O(nlog(n))
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i< array.length;i++){
            int j = BinarySearch(array,i+1,sum-array[i]);
            if(j != -1){
                list.add(array[i]);
                list.add(array[j]);
            }
        }
        int temp = Integer.MAX_VALUE,num1 = 0,num2 = 0;
        for(int i = 0; i<list.size();i+=2){
                if(list.get(i)*list.get(i+1) < temp){
                    num1 = list.get(i);
                    num2 = list.get(i+1);
                    temp = list.get(i)*list.get(i+1);
                }
        }
        list.clear();
        if(num1 != num2){
            list.add(num1);
            list.add(num2);
        }

        return list;
    }
    public static int BinarySearch(int [] arr,int start,int target){
            int end = arr.length-1;
            int mid = 0;
            while(start<=end) {
                mid = start + (end - start) / 2;
                if (arr[mid] == target) return mid;
                else if (arr[mid] < target)
                    start = mid + 1;
                else
                    end = mid - 1;
            }
            return -1;
    }

}
