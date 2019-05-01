package Algorithm.DynamicProgramming.DP02_Triangle;

import java.util.List;

public class Mehtod4 {
    //方法四：动态规划
    public static int minimumTotal(List<List<Integer>> triangle){
        int [] [] matrix = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        for(int i = 0; i < matrix.length;i++){
            for(int j = 0; j < matrix[i].length;j++)
                matrix[i][j] = Integer.MAX_VALUE;

        }
        for(int i = 0; i < triangle.size();i++){
            for(int j = 0; j < triangle.get(i).size();j++)
                matrix[i][j] = triangle.get(i).get(j);

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
        int sum = Integer.MAX_VALUE;
        int i = triangle.size()-1;
        for (int j = 0; j < triangle.get(i).size(); j++){
            if(sum > matrix[i][j])
                sum = matrix[i][j];
        }
        return sum;
    }
}
