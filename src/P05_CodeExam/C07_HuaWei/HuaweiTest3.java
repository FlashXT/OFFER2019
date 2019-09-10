package P05_CodeExam.C07_HuaWei;

import java.util.Arrays;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/10 21:53
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
//岛屿问题
public class HuaweiTest3 {
    static int res = 0;
    public static void main(String [] args){
        char [][]grid={{'1','1','1','1','0'},
                       {'1','1','0','0','0'},
                       {'1','1','0','0','0'},
                       {'0','0','0','0','1'}
                      };

//        for(int i = 0; i < grid.length;i++) {
//            System.out.println(Arrays.toString(grid[i]));
//        }
        numIslands(grid);
    }
    public static int numIslands(char [][] grid){
        res = 0;
        for(int i = 0; i < grid.length;i++){
            for(int j = 0; j < grid[0].length;j++){
                if(grid[i][j]=='1'){
                    res++;
                    DFS(grid,i,j);
                }
            }
        }
//        System.out.println(res);
        return res;
    }
    private static void DFS(char [][] grid,int row,int col){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length){
            return;
        }
        if(grid[row][col] == '1'){
            grid[row][col] = 0;
            DFS(grid,row+1,col);
            DFS(grid,row-1,col);
            DFS(grid,row,col+1);
            DFS(grid,row,col-1);
        }
    }
}
