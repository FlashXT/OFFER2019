package Algorithm.DynamicProgramming.DP02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*********************************************************************************
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
 *      [
 *              [2],
 *             [3,4],
 *            [6,5,7],
 *           [4,1,8,3]
 *       ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 *     Bonus point if you are able to do this using only O(n) extra space, where
 *  n is the total number of rows in the triangle.
 *  //递归同时回溯，其实是暴力穷举，时间超过限制；
 **********************************************************************************/
public class LeetCode120_triangle2 {
    public static void main(String [] args){
        //[[7],[-5,9],[6,5,2],[-8,-2,-7,3],[-2,6,-6,-1,4]]
        List<List<Integer>> list = new ArrayList<>();
        Integer[] arr1 = {7};
        List<Integer> list1 = Arrays.asList(arr1);
        Integer[] arr2 = {-5,9};
        List<Integer> list2 = Arrays.asList(arr2);
        Integer[] arr3 = {6,5,2};
        List<Integer> list3 = Arrays.asList(arr3);
        Integer[] arr4 = {-8,-2,-7,3};
        List<Integer> list4 = Arrays.asList(arr4);
        Integer[] arr5 = {-2,6,-6,-1,4};
        List<Integer> list5 = Arrays.asList(arr5);
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        list.add(list5);
        System.out.println(minimumTotal3(list));

    }

    //方法三：记忆化搜索，自顶向下
    public static int minimumTotal3(List<List<Integer>> triangle) {
        //memo[i]表示当前行第i个位置上的和
        int row = triangle.size();
        int col = triangle.get(triangle.size()-1).size();
        int [] memo = new int[col];

        for(int i = 0; i < memo.length;i++){
            memo[i] = Integer.MAX_VALUE;
        }


        for(int i = 0; i < triangle.size();i++) {
            for (int j = 0; j < triangle.get(i).size(); j++)
                System.out.printf("%4d",triangle.get(i).get(j));
            System.out.println();
        }
        GetMinSum(triangle,row-1,col-1,memo);
        Arrays.sort(memo);
        System.out.println(Arrays.toString(memo));
        return memo[0];

    }
    public static int GetMinSum(List<List<Integer>> triangle,int row,int col,int [] memo){

      if(row <=0 && col<=0)
          return triangle.get(0).get(0);
      if(col > row)
          return Integer.MAX_VALUE;
      if(col < 0)
          return memo[0];
      if(memo[col] != Integer.MAX_VALUE)
          return memo[col];

      for(int i =col;i>=0;i--){
          int v1 = GetMinSum(triangle,row-1,i-1,memo);
          int v2 = GetMinSum(triangle,row-1,i,memo);

          memo[i] = triangle.get(row).get(i)+Math.min(v1,v2);
      }
      return memo[col];
    }



}
