package P05_CodeExam.C03_XiaoHongShu.Problem2;

import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/3,19:30
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/

/*****************
 *input:
 *  5
 * .#...
 * ..#S.
 * .E###
 * .....
 * .....
 * output:4
 */

public class MainDFS {
    static int res = Integer.MAX_VALUE;
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        char [][] grid = new char[n][n];
        int row = 0;
        int col = 0;
        for(int i = 0; i< n;i++){
            String temp = scan.next();

            for(int j = 0; j < n;j++){
                grid[i][j] = temp.charAt(j);
                if(grid[i][j] == 'S')
                {
                    row = i;
                    col = j;
                }
            }
        }
        res = Integer.MAX_VALUE;
        boolean [][] visited = new boolean[n][n];
        MinPathDFS(grid,visited,row,col,0);
        if(res == Integer.MAX_VALUE)
            res = -1;
        System.out.println(res);
    }
    public static void MinPathDFS(char [][]grid,boolean [][] visited,int row,int col,int path){
        if(grid[row][col] == 'E'){
            res = path < res ? path:res;
            return ;
        }
        if(!visited[(row+1)%grid.length][col]&& grid[(row+1)%grid.length][col]!='#'){
            visited[(row+1)%grid.length][col] = true;
            MinPathDFS(grid,visited,(row+1)%grid.length,col,path+1);
            visited[(row+1)%grid.length][col] = false;
        }

        if(!visited[row][(col+1)%grid[col].length] && grid[row][(col+1)%grid.length]!='#'){
            visited[row][(col+1)%grid[col].length] = true;
            MinPathDFS(grid,visited,row,(col+1)%grid[col].length,path+1);
            visited[row][(col+1)%grid[col].length] = false;
        }

        if(!visited[(row-1+grid.length)%grid.length][col]&& grid[(row-1+grid.length)%grid.length][col]!='#'){
            visited[(row-1+grid.length)%grid.length][col] = true;
            MinPathDFS(grid,visited,(row-1+grid.length)%grid.length,col,path+1);
            visited[(row-1+grid.length)%grid.length][col] = false;
        }

        if(col-1 >=0 &&!visited[row][(col-1+grid[col].length)%grid[col].length]&& grid[row][(col-1+grid[col].length)%grid[col].length]!='#'){
            visited[row][(col-1+grid[col].length)%grid[col].length] = true;
            MinPathDFS(grid,visited,row,(col-1+grid[col].length)%grid[col].length,path+1);
            visited[row][(col-1+grid[col].length)%grid[col].length] = false;
        }

    }
}
