package DataStructure.CH3_MatrixPrint;

/*
 * 按照"之"字形打印矩阵；
 */
public class MatrixPrint2 {

    public static void main(String[] args) {
        int[][] matrix = {
                {  1,  2,  3, 4 },
                {  5,  6,  7, 8 },
                {  9, 10, 11, 12},
                { 13, 14, 15, 16}


        };
        ZhiziPrint(matrix);

    }

    public static void ZhiziPrint(int [][] matrix){
        int col = 0;
        int row = 0;
        int m = matrix.length-1;
        int n = matrix[0].length-1;
        while(col <= m*n && row < m*n){
            printEdge(matrix,row++,col++);
        }

    }


    public static void printEdge(int [][]matrix,int row,int col){
        int m = matrix.length-1;
        int n = matrix[0].length-1;
        //从上往下打印
        if(col %2 ==1){
            if(row <= m && col <= n){
                for(int i = 0,j = col; i <= row && j >= 0 ;i++,j--)
                    System.out.printf("%4d",matrix[i][j]);
            }
            else if(row > m && col <= n){
                for(int i = col-n,j = col ; i <= m && j >= row-m ;i++,j--)
                    System.out.printf("%4d",matrix[i][j]);
            }
            else if(row > m && col >n){
                for(int i = col-n,j = n ; i <= m&& j >= row-m ;i++,j--)
                    System.out.printf("%4d",matrix[i][j]);
            }
            else if(row <= m && col > n){
                for(int i = col-n,j = n ; i <= row && j >= row-m ;i++,j--)
                    System.out.printf("%4d",matrix[i][j]);
            }
        }
        //从下往上打印
        else{
            if(row <= m && col <= n){
                for(int i = row,j = 0; i >= 0 && j <= col ;i--,j++)
                    System.out.printf("%4d",matrix[i][j]);
            }
            else if(row > m && col <= n){
                for(int i = m ,j = row-m ; i >= col-n && j <=col  ;i--,j++)
                    System.out.printf("%4d",matrix[i][j]);
            }
            else if(row > m && col >n){
                for(int i = m ,j = row-m ; i >= col-n && j <=n   ;i--,j++)
                    System.out.printf("%4d",matrix[i][j]);
            }
            else if(row <= m && col > n){
                for(int i = row ,j = row-m ; i >= col-n && j <= n  ;i--,j++)
                    System.out.printf("%4d",matrix[i][j]);

            }

        }

    }

}
