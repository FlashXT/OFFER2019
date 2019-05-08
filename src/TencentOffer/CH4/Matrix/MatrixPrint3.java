package TencentOffer.CH4.Matrix;

/********************************************************************************
 * 按照"之"字形打印矩阵；
 * 思路：用两个点一个沿着先走列后走行，另一个点沿着先走行后走列，这两个点会指出一个对角线，
 *      然后按照从上到下或者从下到上的顺序输出；
 *
 ********************************************************************************/
public class MatrixPrint3 {

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };
        ZhiziPrint(matrix);
    }

    public static void ZhiziPrint(int [][] matrix){
        // (row0,col0)点先走列后走行
        int row0 = 0;
        int col0 = 0;
        // (row1,col1)点先走行后走列
        int row1 = 0;
        int col1 = 0;
        boolean uptobase = false;
        int m = matrix.length-1;
        int n = matrix[0].length-1;

        while(row0<= m){
            printEdge(matrix,row0,col0,row1,col1,uptobase);

            //顺序不能改变
            row0 = col0 >= n ? row0+1:row0;
            col0 = col0 >= n ? col0:col0+1;
            col1 = row1 >= m ? col1+1:col1;
            row1 = row1 >= m ? row1:row1+1;

            uptobase = !uptobase;
        }

    }

    public static void printEdge(int [][]matrix,int row0,int col0,int row1,int col1,boolean uptobase){

        //给出两个点坐标，一个用于输出，一个用于控制输出边界
        if(uptobase){
            while(row0 <= row1)
                System.out.printf("%2d\t",matrix[row0++][col0--]);
        }
        else{
            while(row1 >= row0)
                System.out.printf("%2d\t",matrix[row1--][col1++]);
        }

    }

}
