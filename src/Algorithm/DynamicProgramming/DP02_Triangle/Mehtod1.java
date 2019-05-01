package Algorithm.DynamicProgramming.DP02_Triangle;

import java.util.List;

public class Mehtod1 {

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
