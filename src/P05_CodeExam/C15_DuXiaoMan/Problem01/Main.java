package P05_CodeExam.C15_DuXiaoMan.Problem01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/15,18:21
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Main {
    static  int res = Integer.MAX_VALUE;
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt()+500;
        int y = scan.nextInt()+500;
        int N = scan.nextInt();
        int [][] arr = new int[1001][1001];
        for(int i = 0 ;i < N;i++)
            arr[scan.nextInt()+500][scan.nextInt()+500]=1;
        res = Integer.MAX_VALUE;
        boolean [][] visited = new boolean[1001][1001];
        int res = BFS(arr,visited,x,y,500,500);
        System.out.print(res);
    }
    public static int BFS(int[][] grid,boolean [][]visited,int dx,int dy,int sx,int sy){
        visited[sx][sy]=true;
        int [][] path = new int[1001][1001];
        int [][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{sx,sy});
        while(!queue.isEmpty()){
            int [] temp = queue.poll();
            if(temp[0] == dx && temp[1] == dy)
                break;
            for(int i = 0; i< 4;i++){
                int nx = temp[0]+dir[i][0];
                int ny = temp[1]+dir[i][1];
                if(nx >=0 && nx < 1001 && ny >=0 && ny <1001 && !visited[nx][ny] &&grid[nx][ny]!=1){
                    queue.add(new int[]{nx,ny});
                    visited[nx][ny] = true;
                    path[nx][ny] = path[temp[0]][temp[1]]+1;
                }
            }
        }
        return path[dx][dy];
    }
}
