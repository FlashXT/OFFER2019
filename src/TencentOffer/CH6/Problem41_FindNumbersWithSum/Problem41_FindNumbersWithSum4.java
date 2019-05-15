package TencentOffer.CH6.Problem41_FindNumbersWithSum;

import java.util.ArrayList;
import java.util.Arrays;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/15 10:58;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Problem41_FindNumbersWithSum4 {
    public static void main(String [] args){
        int [] arr = {1,2,4,7,11,15};
        ArrayList<Integer> list = FindNumbersWithSum(arr,12);
        System.out.println(Arrays.toString(list.toArray()));
    }
    //复杂度O(n)
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if(array.length == 0) return list;
        int start = 0;
        int end = array.length-1;

        int temp ;
        while(start < end){
            temp = sum - array[start];
            if(temp < array[end])
                end--;
            else if(temp > array[end])
                start++;
            else
                break;
        }
        if(start == end) return list;
        list.add(array[start]);
        list.add(array[end]);

        return list;
    }


}
