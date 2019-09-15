package P03_Algorithm.A05_BFS;

import java.util.Arrays;
import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/15,21:09
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
/*
    test case:
    input:  2 0 3
            1 0
            1 1
            1 -1
    output：6
 */
public class Main {
    static int res = Integer.MAX_VALUE;
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt()+500;
        int y = sc.nextInt()+500;
        int N = sc.nextInt();
        int [][] arr = new int[1001][1001];
        for(int i = 0 ;i < N;i++)
            arr[sc.nextInt()+500][sc.nextInt()+500]=1;

        res = new Solution2_BFS().BFS(arr,x,y,500,500);
        System.out.print(res);
    }
}
