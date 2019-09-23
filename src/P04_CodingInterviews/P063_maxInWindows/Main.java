package P04_CodingInterviews.P063_maxInWindows;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/19,21:07
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Main {
    public static void main(String [] args){
        int [] nums = {2,3,4,2,6,2,5,1};
        ArrayList<Integer> res;
        res = new Method2().maxInWindows(nums,3);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
