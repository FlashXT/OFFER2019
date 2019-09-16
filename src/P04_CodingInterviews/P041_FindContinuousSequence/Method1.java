package P04_CodingInterviews.P041_FindContinuousSequence;

import java.util.*;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/16,11:13
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(sum < 3) return res;
        int small = 1,big = 2;
        int mid = (1+sum)/2 ;
        int cursum = small+big;
        while(small < mid){
            if(cursum == sum){
                ArrayList<Integer> temp = new ArrayList<>();
                for(int i = small; i <=big;i++)
                    temp.add(i);
                res.add(temp);
                cursum-=small;
                small++;
            }
            if(cursum < sum){
                big++;
                cursum+=big;
            }
            if(cursum > sum){
                cursum-=small;
                small++;
            }
        }
        Iterator<ArrayList<Integer>> iter = res.iterator();
        while(iter.hasNext())
            System.out.print(Arrays.toString(iter.next().toArray()));
       return res;
    }
}
