package P04_CodingInterviews.P063_maxInWindows;

import java.util.ArrayList;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/19,21:07
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
//暴力法O(n^2)
public class Method1 {
    public ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> res = new ArrayList<>();
        if(size == 0) return res;
        for(int i = 0 ;i < num.length-size+1;i++){
           res.add(getMax(num,i,i+size-1));
        }
        return res;

    }
    private int getMax(int[] nums,int start,int end){
        int max = nums[start];
        for(int i = start+1; i <= end;i++){
            if(nums[i] > max)
                max = nums[i];
        }
        return max;
    }
}
