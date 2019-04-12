package DataStructure.CH3_MatrixPrint;

/*
 * 转圈打印矩阵；
 */
public class MatrixPrint1 {

    public static void main(String[] args) {
        int[][] matrix = {
                {  1,  2,  3,  4 },
                {  5,  6,  7,  8 },
                {  9, 10, 11, 12 },
                { 13, 14, 15, 16 }

        };
        aroundPrint(matrix);
    }

    public static void aroundPrint(int [][] matrix){
        int m = matrix.length;          //矩阵的行
        int n = matrix[0].length;       //矩阵的列
        int rowL = 0,rowR = m-1;
        int colL = 0,colR = n-1;
        while(rowL<rowR || colL<colR){
            printEdge(matrix,rowL++,colL++,rowR--,colR--);
        }

    }
    public static void printEdge(int [][]matrix,int rowL,int colL,int rowR,int colR){
        //从左到右打印一行
        for(int i = colL; i <= colR;i++){
            System.out.printf("%2d\t",matrix[rowL][i]);
        }
        //从上到下打印一列
        for(int j = rowL+1; j <= rowR;j++){
            System.out.printf("%2d\t",matrix[j][colR]);
        }
        //从右到左打印一行
        for(int p = colR-1; p >= colL;p--){
            System.out.printf("%2d\t",matrix[rowR][p]);
        }
        //从下到上打印一列
        for(int q = rowR-1;q > rowL;q--){
            System.out.printf("%2d\t",matrix[q][colL]);
        }

    }


}
