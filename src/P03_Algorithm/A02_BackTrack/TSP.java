package P03_Algorithm.A02_BackTrack;

import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/4,8:55
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
//西安三星研究院上机题：旅行商问题
/*
    测试用例说明：
     第一行输入一个整数K表示测试用例组数
     接下来的K行：
        第一个数表示要遍历的点的个数N，接下来每两个数表示一个点的X和Y坐标；
        前两个数表示起点的坐标，中间的 2N个数表示要遍历的N个点的坐标，最后两个数表示终点的坐标
     示例：
        2
        5 0 0 20 30 10 30 40 50 70 10 40 80 100 100
        3 0 0 25 25 50 50 75 75 100 100

 */
public class TSP {
    static int Answer = Integer.MAX_VALUE;
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int testcase = scan.nextInt();
        for(int i = 0 ; i < testcase;i++){
            int N = scan.nextInt();
            int startX = scan.nextInt();
            int startY = scan.nextInt();
            int [] CX = new int[N];
            int [] CY = new int[N];
            for(int j = 0; j < N;j++){
                CX[j] = scan.nextInt();
                CY[j] = scan.nextInt();
            }
            int endX = scan.nextInt();
            int endY = scan.nextInt();
            Answer = Integer.MAX_VALUE;
            boolean [] visited = new boolean[N];
            MinPath(startX,startY,endX,endY,CX,CY,visited,-1,0);
            System.out.println(Answer);
        }
    }
    public static void MinPath(int startX,int startY,int endX,int endY,int [] CX,int[]CY,boolean[]visited,int lastVisited,int path){
        if(AllVisited(visited)){

            path += Math.abs(endX-CX[lastVisited])+Math.abs(endY-CY[lastVisited]);
            Answer = Answer > path?path:Answer;
            return ;
        }
        for(int i =0 ; i < CX.length;i++){
            int X = lastVisited == -1 ? startX:CX[lastVisited];
            int Y = lastVisited == -1 ? startY:CY[lastVisited];

            if(!visited[i]){
                visited[i] = true;
                path+=Math.abs(CX[i] - X)+Math.abs(CY[i] - Y);

                MinPath(startX,startY,endX,endY,CX,CY,visited,i,path);

                path-=Math.abs(CX[i] - X)+Math.abs(CY[i] - Y);
                visited[i] = false;
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
