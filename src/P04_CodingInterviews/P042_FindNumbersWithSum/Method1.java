package P04_CodingInterviews.P042_FindNumbersWithSum;

import java.util.ArrayList;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/16,14:14
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        int start = 0;
        int end = array.length-1;
        int temp = 0;
        while(start < end){
            temp = array[start]+array[end];
            if(temp == sum){
                res.add(array[start]);
                res.add(array[end]);
                break;
            }
            else if(temp > sum)
                end--;
            else
                start++;
        }
        return res;
    }
}
