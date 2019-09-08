package P04_CodingInterviews.P018_PrintMatrix;

import java.util.ArrayList;
import java.util.Iterator;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/8,10:27
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int rows = 0,rowe = matrix.length-1;
        int cols = 0,cole = matrix[0].length-1;
        while(rows < rowe && cols < cole){

            Print(matrix,rows++,rowe--,cols++,cole--,res);
        }
        Iterator<Integer> iter = res.iterator();
        while(iter.hasNext()){
            System.out.print(iter.next()+"\t");
        }
        System.out.println();
        return res;
    }
    private void Print(int [][] matrix,int rows,int rowe,int cols,int cole,ArrayList<Integer> res) {
        //从左向右打印一行
        for(int col = cols; col <= cole;col++){
            res.add(matrix[rows][col]);
            System.out.print(matrix[rows][col]+"\t");
        }


        //从上到下打印一列
        for(int row = rows+1;row <=rowe;row++){
            res.add(matrix[row][cole]);
            System.out.print(matrix[row][cole]+"\t");
        }


        //从右向左打印一行
        if(rows < rowe){
            for(int col = cole-1; col >= cols;col--){
                res.add(matrix[rowe][col]);
                System.out.print(matrix[rowe][col]+"\t");
            }

        }

        //从下到上打印一列
        if(cols < cole){
            for(int row = rowe -1; row > rows;row--){
                res.add(matrix[row][cols]);
                System.out.print(matrix[row][cols]+"\t");
            }
        }

    }
}
