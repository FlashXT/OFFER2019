package P04_CodingInterviews.P064_hasPath;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/19,21:02
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method2 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        if(matrix == null || rows <1 || cols <1 || str == null) return false;
        boolean [] visited = new boolean[rows*cols];
        for(int row = 0; row < rows;row++){
            for(int col = 0; col < cols;col++){
                if(hasPath(matrix,rows,cols,row,col,str,0,visited))
                    return true;
            }
        }
        return false;
    }

    private boolean hasPath(char[] matrix, int rows, int cols,int row, int col, char[] str,int index,boolean [] visited){
        if(index >= str.length) return true;
        boolean res = false;
        if(row  >= 0 && row < rows && col >= 0 && col < cols && !visited[row*cols+col]&&matrix[row*cols+col]==str[index]){
            int[][]dir = {{-1,0},{1,0},{0,-1},{0,1}};
            visited[row*cols+col] = true;
            for(int i = 0 ; i < dir.length;i++){
                res = res|| hasPath(matrix,rows,cols,row+dir[i][0],col+dir[i][1],str,index+1,visited);
            }
            if(!res)
                visited[row*cols+col] = false;
        }
        return res;


    }
}
