package P03_Algorithm.A05_BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/15,18:21
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
//数据规模过大，栈溢出
public class Solution1_DFS {
    static int res = Integer.MAX_VALUE;
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt()+500;
        int y = sc.nextInt()+500;
        int N = sc.nextInt();
        int [][] arr = new int[1001][1001];
        for(int i = 0 ;i < N;i++)
            arr[sc.nextInt()+500][sc.nextInt()+500]=1;
        for(int i = 0; i < arr.length;i++){
            System.out.println(Arrays.toString(arr[i]));
        }
        res = Integer.MAX_VALUE;

        boolean [] []visited = new boolean[1001][1001];

        new Solution1_DFS().DFS(arr,visited,x,y,500,500,0);
        System.out.print(res);
    }
    public static int DFS(int[][] grid,boolean [][]visited,int dx,int dy,int sx,int sy,int path){
        if(sx <0 || sx >= grid.length || sy < 0 || sy >= grid[0].length)
            return res;
        if(sx == dx && sy == dy){
            res = res > path?path:res;
            return res;
        }

        if(sx > 0 && !visited[sx-1][sy]&&grid[sx-1][sy]!=1){
            visited[sx-1][sy] = true;
            DFS(grid,visited,dx,dy,sx-1,sy,path+1);
            visited[sx-1][sy] = false;
        }

        if(sx <grid.length-1&& !visited[sx+1][sy] && grid[sx+1][sy]!=1){
            visited[sx+1][sy] = true;
            DFS(grid,visited,dx,dy,sx+1,sy,path+1);
            visited[sx+1][sy] = false;
        }
        if(sy >0 && !visited[sx][sy-1]&& grid[sx][sy-1]!=1){
            visited[sx][sy-1] = true;
            DFS(grid,visited,dx,dy,sx,sy-1,path+1);
            visited[sx][sy-1] = false;
        }

        if(sy < grid[0].length-1&& !visited[sx][sy+1]&&grid[sx][sy+1]!=1){
            visited[sx][sy+1] = true;
            DFS(grid,visited,dx,dy,sx,sy+1,path+1);
            visited[sx][sy+1] = false;
        }
        return res;
    }
}
