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

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        Queue<int []> queue = new LinkedList<>();
        boolean [] visited = new boolean[rows*cols];
        queue.offer(new int[]{0,0});
        int [] [] dir = {{-1,0},{1,0},{0,1},{0,-1}};
        int index = 0;
        while(!queue.isEmpty()){
            if(index == str.length)break;
            int[] temp = queue.poll();
            visited[temp[0]*cols+temp[1]] = true;
            if(matrix[temp[0]*cols+temp[1]]==str[index]){
                index++;
            }
            for(int i = 0; i < dir.length;i++){
                int row = temp[0]+dir[i][0];
                int col = temp[1]+dir[i][1];
                if(row >=0  && row< rows && col >= 0 && col < cols && !visited[row*cols+col]){

                    if(matrix[row*cols+col]==str[index]){
                        queue.offer(new int [] {row,col});
                        index++;
                    }
                }

            }
        }

        if(index == str.length)
            return true;
        else
            return false;
    }
}
