package Algorithm.DynamicProgramming.DP02_Triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Mehtod3 {
    //方法三：记忆化搜索，自顶向下
    public static int minimumTotal(List<List<Integer>> triangle) {
        //memo[i]表示当前行第i个位置上的和
        int row = triangle.size();
        int col = triangle.get(triangle.size()-1).size();
        int [] memo = new int[col];

        for(int i = 0; i < memo.length;i++){
            memo[i] = Integer.MAX_VALUE;
        }

        GetMinSum(triangle,row-1,col-1,memo);
        Arrays.sort(memo);
        return memo[0];

    }
    private static int GetMinSum(List<List<Integer>> triangle,int row,int col,int [] memo){

        if(row <=0 && col<=0)
            return triangle.get(0).get(0);
        if(col > row)
            return Integer.MAX_VALUE;
        if(col < 0)
            return memo[0];
        if(memo[col] != Integer.MAX_VALUE)
            return memo[col];

        //i = col，表示从右往左算
        for(int i =col;i>=0;i--){
            int v1 = GetMinSum(triangle,row-1,i-1,memo);
            int v2 = GetMinSum(triangle,row-1,i,memo);

            memo[i] = triangle.get(row).get(i)+Math.min(v1,v2);
        }
        return memo[col];
    }
}
