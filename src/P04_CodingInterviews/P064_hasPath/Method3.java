package P04_CodingInterviews.P064_hasPath;

import java.util.LinkedList;
import java.util.Queue;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/23,11:27
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method3 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if(matrix == null||rows < 1 ||cols <1||str == null) return false;
        for(int row = 0 ; row < rows;row++){
            for(int col = 0; col < cols;col++){
                if(Path(matrix,rows,cols,row,col,str))
                    return true;
            }
        }
        return false;
    }
    private boolean Path(char[] matrix, int rows, int cols,int row,int col, char[] str){

        Queue<int []> queue = new LinkedList<>();
        boolean [] visited = new boolean[rows*cols];
        visited[row*cols+col] = true;
        queue.offer(new int[]{row,col});
        int [] [] dir = {{-1,0},{1,0},{0,1},{0,-1}};
        int index = 0;
        boolean flag = false;
        while(!queue.isEmpty()&& index < str.length){

            int[] temp = queue.poll();
            if(matrix[temp[0]*cols+temp[1]]==str[index]){
                visited[temp[0]*cols+temp[1]] = true;
                index++;
                if(index == str.length) break;
                flag = false;
                for(int i = 0; i < dir.length;i++){
                    int temprow = temp[0]+dir[i][0];
                    int tempcol = temp[1]+dir[i][1];
                    if(index < str.length
                            && temprow >= 0 && temprow < rows
                            && tempcol >= 0 && tempcol < cols
                            && !visited[temprow*cols+tempcol]
                            &&matrix[temprow*cols+tempcol]==str[index]){
                        queue.offer(new int [] {temprow,tempcol});
                        visited[temprow*cols+tempcol] = true;
                        flag = true;

                    }

                }
                //类似回溯，如果从当前点出发找不到下一个点，则将当前点置为未遍历过；
                if(!flag){
                    visited[temp[0]*cols+temp[1]] = false;
                    index--;
                }

            }


        }

        if(index == str.length)
            return true;
        else
            return false;
    }
}
