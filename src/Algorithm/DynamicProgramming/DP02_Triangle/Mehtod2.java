package Algorithm.DynamicProgramming.DP02_Triangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mehtod2 {

    //方法二：正确的思路与方法，但是不满足要求
    public static int minimumTotal(List<List<Integer>> triangle) {
        int sum = 0;
        //不确定共有几种枚举结果，所以使用变长数据结构；Vector,set都可以，
        //最终要求集合中的最小值，并不要求集合有序
        ArrayList<Integer> arrlist = new ArrayList<>();

        GetMinsum(triangle,0,0,sum,arrlist);
        return Collections.min(arrlist);
//        int [] arr = new int[MainClass_triangle.size()];
//        GetMinsumWithPath(MainClass_triangle,0,0,sum,arr);
//        return 0;

    }
    private static void GetMinsum(List<List<Integer>> triangle,int row,int col,int sum,ArrayList<Integer> arrlist){

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
    private static void GetMinsumWithPath(List<List<Integer>> triangle,int row,int col,int sum,int [] arr){
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
}
