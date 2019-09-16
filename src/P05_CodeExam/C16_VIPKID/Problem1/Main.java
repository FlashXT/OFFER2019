package P05_CodeExam.C16_VIPKID.Problem1;

import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/16,15:47
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
/*
    input:
        3
        1 2
        3 2
        2 2
        2 2
        2 3
        3 6
        4 6
        3 3
        3 4

  output:
          0
          3
          7
 */
public class Main {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        for(int i = 0; i < T;i++){
            int n = scan.nextInt();
            int m = scan.nextInt();
            int [] cost = new int [n];
            int [] value = new int[n];
            for(int j = 0 ;j < n;j++){
                cost[j] = scan.nextInt();
                value[j] = scan.nextInt();
            }
            int res = DP(value, cost,m);
            System.out.println(res);
        }

    }

    public static int DP(int [] value,int []cost,int m){

        //memo[i][j] 表示学习第i个课程后能获得的最大分数
        int [][]memo = new int[cost.length][m+1];
        for(int j = 0; j <=m;j++){
            memo[0][j] = j >=cost[0]?value[0]:0;
        }

        for(int i = 1; i <cost.length;i++){
            for(int j = 0;  j<= m;j++){

                memo[i][j] = memo[i-1][j];
                if(j >= cost[i])
                    memo[i][j] = Math.max(memo[i][j],memo[i-1][j-cost[i]]+value[i]);
            }
        }
        return memo[cost.length-1][m];
    }
}
