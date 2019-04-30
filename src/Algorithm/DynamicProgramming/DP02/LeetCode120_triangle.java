package Algorithm.DynamicProgramming.DP02;

import sun.plugin.viewer.context.IExplorerAppletContext;

import java.util.*;

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
public class LeetCode120_triangle {
    public static void main(String [] args){
        //[[7],[-5,9],[6,5,2],[-8,-2,-7,3],[-2,6,-6,-1,4]]
        List<List<Integer>> list = new ArrayList<>();
        Integer[] arr1 = {2};
        List<Integer> list1 = Arrays.asList(arr1);
        Integer[] arr2 = {3,4};
        List<Integer> list2 = Arrays.asList(arr2);
        Integer[] arr3 = {6,5,7};
        List<Integer> list3 = Arrays.asList(arr3);
        Integer[] arr4 = {4,1,8,3};
        List<Integer> list4 = Arrays.asList(arr4);
//        Integer[] arr5 = {-2,6,-6,-1,4};
//        List<Integer> list5 = Arrays.asList(arr5);
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
//        list.add(list5);
//        System.out.println(minimumTotal2(list));

//        System.out.println(minimumTotal3(list));
//        System.out.println(minimumTotalDP1(list));
        System.out.println(minimumTotalDP2(list));


    }
    //方法五：动态规划改进
    public static int minimumTotalDP2(List<List<Integer>> triangle){

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
    //方法四：动态规划
    public static int minimumTotalDP1(List<List<Integer>> triangle){
        int [] [] matrix = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        for(int i = 0; i < matrix.length;i++){
            for(int j = 0; j < matrix[i].length;j++)
                matrix[i][j] = Integer.MAX_VALUE;

        }
        for(int i = 0; i < triangle.size();i++){
           for(int j = 0; j < triangle.get(i).size();j++)
               matrix[i][j] = triangle.get(i).get(j);

        }
        for(int i = 0; i < triangle.size();i++) {
            for (int j = 0; j < triangle.get(i).size(); j++)
                System.out.printf("%4d",matrix[i][j]);
            System.out.println();
        }
        int temp;
        for(int i = 1; i < triangle.size();i++) {
            for (int j = 0; j < triangle.get(i).size(); j++){

                if( j-1 <0)
                    matrix[i][j] += matrix[i-1][j];
                else if(j > triangle.get(i-1).size())
                    matrix[i][j] += matrix[i-1][j-1];
                else{
                    if(matrix[i-1][j] == Integer.MAX_VALUE)
                        temp = matrix[i-1][j-1];
                    else
                        temp = matrix[i-1][j-1] < matrix[i-1][j]?matrix[i-1][j-1]:matrix[i-1][j];

                    matrix[i][j] += temp;

                }

            }
        }
        System.out.println("====================");
        for(int i = 0; i < triangle.size();i++) {
            for (int j = 0; j < triangle.get(i).size(); j++)
                System.out.printf("%4d",matrix[i][j]);
            System.out.println();
        }
        int sum = Integer.MAX_VALUE;
        int i = triangle.size()-1;
            for (int j = 0; j < triangle.get(i).size(); j++){
                if(sum > matrix[i][j])
                    sum = matrix[i][j];
        }
        return sum;
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


//        for(int i = 0; i < triangle.size();i++) {
//            for (int j = 0; j < triangle.get(i).size(); j++)
//                System.out.printf("%4d",triangle.get(i).get(j));
//            System.out.println();
//        }
        GetMinSum(triangle,row-1,col-1,memo);
        Arrays.sort(memo);
//        System.out.println(Arrays.toString(memo));
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
    //方法二：正确的思路与方法，但是不满足要求
    public static int minimumTotal2(List<List<Integer>> triangle) {
        int sum = 0;
        //不确定共有几种枚举结果，所以使用变长数据结构；Vector,set都可以，
        //最终要求集合中的最小值，并不要求集合有序
        ArrayList<Integer> arrlist = new ArrayList<>();

        GetMinsum(triangle,0,0,sum,arrlist);
        return Collections.min(arrlist);
//        int [] arr = new int[triangle.size()];
//        GetMinsumWithPath(triangle,0,0,sum,arr);
//        return 0;

    }
    public static void GetMinsum(List<List<Integer>> triangle,int row,int col,int sum,ArrayList<Integer> arrlist){

        if(row == triangle.size() || col == triangle.get(row).size()){
            //每次遍历最终的和保存到数组中
            arrlist.add(sum);
            return ;
        }


        for(int i = col; i< Math.min(col+2,triangle.get(row).size());i++) {
            sum += triangle.get(row).get(i);
            GetMinsum(triangle, row + 1, i, sum, arrlist); //试探

            sum -= triangle.get(row).get(i);                   //回溯

        }
    }
    public static void GetMinsumWithPath(List<List<Integer>> triangle,int row,int col,int sum,int [] arr){
        //递归试探与回溯，运行时间超过限制
        if(row == triangle.size() || col == triangle.get(row).size()){
            //该方法输出每次试探的路径
            for(int item: arr){
                System.out.printf("%2d ->",item);
            }
            System.out.printf("(%2d)\n",sum);

            return ;
        }

        for(int i = col; i< Math.min(col+2,triangle.get(row).size());i++) {
            arr[row] = triangle.get(row).get(i);
            sum += arr[row];
            GetMinsumWithPath(triangle, row + 1, i, sum, arr); //试探
            sum -= triangle.get(row).get(i);                       //回溯

        }
    }
    //方法一：错误的尝试
    public static int minimumTotal(List<List<Integer>> triangle) {
        //贪心法，并不能解决问题
        int sum = triangle.get(0).get(0);
        int index = 0;
        for(int i =1;i< triangle.size();i++){
            if(triangle.get(i).get(index) > triangle.get(i).get(index+1)){
                index = index+1;
                sum+= triangle.get(i).get(index);
            }
            else{
                sum+= triangle.get(i).get(index);
            }
        }
        return sum;
    }
}
