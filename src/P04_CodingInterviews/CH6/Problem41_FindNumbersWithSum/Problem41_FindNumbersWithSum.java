package P04_CodingInterviews.CH6.Problem41_FindNumbersWithSum;

import java.util.ArrayList;
import java.util.Arrays;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/15 10:58;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Problem41_FindNumbersWithSum {
    public static void main(String [] args){
        int [] arr = {1,2,4,7,11,15};
        ArrayList<Integer> list = FindNumbersWithSum(arr,15);
        System.out.println(Arrays.toString(list.toArray()));
    }
    //复杂度O(n^2)
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i< array.length;i++){
            for(int j = i+1; j<array.length;j++){
                if(array[i]+array[j] == sum){
                    list.add(array[i]);
                    list.add(array[j]);
                }
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
}
