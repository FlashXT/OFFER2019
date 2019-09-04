package P05_CodeExam.C06_XieCheng.Problem3;

import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/4 18:42
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
/*
  input:
        4
        6
        0 1 4
        0 2 3
        0 3 1
        1 2 1
        1 3 2
        2 3 5

  output:7
 */
public class Main {
    static int Answer = Integer.MAX_VALUE;
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int [] [] graph = new int[N][N];
        int V = scan.nextInt();

        for(int i = 0; i < V;i++){
            int row = scan.nextInt();
            int col = scan.nextInt();
            int time  = scan.nextInt();
            graph[row][col] = time;
            graph[col][row] = time;
        }
        Answer = Integer.MAX_VALUE;
        boolean[]visited = new boolean[N];

        MinPath(0,graph,visited,-1,0);

        if(Answer == Integer.MAX_VALUE)
            System.out.println("-1");
        else
            System.out.println(Answer);
    }
    public static void MinPath(int startnode,int [][] graph,boolean[]visited,int lastnode,int time){
        if(AllVisited(visited)){
            if(startnode == lastnode)
                Answer = Answer > time?time:Answer;
            return ;
        }
        lastnode = lastnode == -1 ? 0:lastnode;
        for(int j = 0 ;j < graph.length;j++){
            if(!visited[j]&&graph[lastnode][j] > 0){
                visited[j] = true;
                MinPath(startnode,graph,visited,j,time+graph[lastnode][j]);
                visited[j] = false;
            }

        }

    }
    public static boolean AllVisited(boolean [] visited){
        for(int i = 0; i < visited.length;i++){
            if(!visited[i])
                return false;
        }
        return true;
    }
}
