package Algorithm.DynamicProgramming.DP02_Triangle;

import java.util.Arrays;
import java.util.List;

public class Mehtod5 {
    //方法五：动态规划改进
    public static int minimumTotal(List<List<Integer>> triangle){

        //memo[i]表示计算到第i行各个位置上的最小和
        int [] memo = new int[triangle.get(triangle.size()-1).size()];
        for(int i = 0; i < memo.length;i++)
            memo[i] = Integer.MAX_VALUE;
        memo[0] = triangle.get(0).get(0);
        int row = triangle.size(),col;
        for(int i = 1; i < row;i++) {
            col = triangle.get(i).size();

            for (int j =col-1; j >0; j--){
                int temp = Math.min(memo[j-1],memo[j]);
                memo[j]= temp + triangle.get(i).get(j);
            }
            memo[0]+=triangle.get(i).get(0);
        }

        Arrays.sort(memo);
        return memo[0];
    }
}
