package P04_CodingInterviews.P018_PrintMatrix;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/8,10:27
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Main {
    public static  void main(String [] agrs){
        int [][]matrix = {{1},{2},{3},{4},{5}};
        for(int i = 0; i<matrix.length;i++){
            for(int j = 0; j < matrix[i].length;j++){
                System.out.printf("%-3d\t",matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        new Method1().printMatrix(matrix);
    }
}
