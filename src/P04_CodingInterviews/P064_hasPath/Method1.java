package P04_CodingInterviews.P064_hasPath;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/19,21:02
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        if(matrix == null || rows <1 || cols <1 || str ==null) return false;
        boolean [] visited = new boolean[rows*cols];
        for(int row = 0; row < rows;row++){
            for(int col = 0; col < cols;col++){
                if(PathsInMatrix(matrix,rows,cols,row,col,str,0,visited))
                    return true;
            }
        }
        return  false;
    }
    public static boolean PathsInMatrix(char[] matrix, int rows, int cols,int row, int col, char[] str,int index,boolean[]visited){
        if(index >= str.length) return true;
        boolean hasPath = false;
        if(row >= 0 && row < rows && col >=0 && col < cols && matrix[row*cols+col]==str[index]&& !visited[row*cols+col]){
            index++;
            visited[row*cols+col]=true;
            hasPath = PathsInMatrix(matrix,rows,cols,row,col-1,str,index,visited)||
                    PathsInMatrix(matrix,rows,cols,row,col+1,str,index,visited)||
                    PathsInMatrix(matrix,rows,cols,row-1,col,str,index,visited)||
                    PathsInMatrix(matrix,rows,cols,row+1,col,str,index,visited);
            if(!hasPath){
                index--;
                visited[row*cols+col] = false;
            }
        }
        return hasPath;

    }
}
