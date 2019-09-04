package P05_CodeExam.C05_XiaoHongShu.Problem2;

import java.util.LinkedList;
import java.util.Queue;
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

public class MainBFS {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        char [][] grid = new char[n][n];
        int [] begin = new int [2];
        int [] end = new int [2];
        for(int i = 0; i< n;i++){
            String temp = scan.next();
            for(int j = 0; j < n;j++){
                grid[i][j] = temp.charAt(j);
                if(grid[i][j] == 'S') {
                    begin[0] = i;
                    begin[1] = j;
                }
                if(grid[i][j] == 'E') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        int res = MinPathBFS(grid,begin,end);
        System.out.println(res);
    }
    public static int MinPathBFS(char [][]grid,int [] begin,int [] end){
        //记录对应位置的距离
        int [] [] path = new int [grid.length][grid[0].length];
        //储存未处理的点
        Queue<int []> que = new LinkedList<>();
        //每个位置的距离初始化为最大值
        for(int i = 0; i < path.length;i++){
            for(int j = 0; j < path[0].length;j++){
                path[i][j] = Integer.MAX_VALUE;
            }
        }
        //定义方向向量
        int [] drow = {0,1,0,-1};
        int [] dcol = {1,0,-1,0};
        que.offer(begin);
        //起点到自己的最短路径为0
        path[begin[0]][begin[1]] = 0;
        while(!que.isEmpty()){
            int [] curr = que.poll();
            if(curr[0] == end[0] && curr[1] == end[1])
                break;
            //四个方向循环遍历
            for(int i = 0; i < 4;i++){
                //如果上下左右互通
                int row = (curr[0]+ drow[i]+grid.length)%grid.length;
                int col = (curr[1]+ dcol[i]+grid.length)%grid.length;
                //如果不能走
                if(grid[row][col]=='#' || path[row][col]!=Integer.MAX_VALUE)
                    continue;
                //如果能走
                path[row][col] = path[curr[0]][curr[1]]+1;
                int [] pos = {row,col};
                que.offer(pos);
            }
        }
        return path[end[0]][end[1]];
    }
}
