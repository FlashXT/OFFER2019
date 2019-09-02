package P05_CodeExam.JD.P05Maze;

import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/8/24,19:53
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/

/*
思路：分情况讨论
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int k = 0; k < t; k++) {
            int m = scan.nextInt();
            int n = scan.nextInt();
            char[][] arr = new char[m][n];
            int i = 0, j = 0;
            for (int p = 0; p < m; p++) {
                arr[p] = scan.next().toCharArray();
                for (int q = 0; q < n; q++){
                    if (arr[p][q] == 'S') {
                        i = p;
                        j = q;
                    }
                }
            }
            boolean flag1 = true;
            //①判断s所在的行列
            for (int col = 0; col < n; col++) {
                if (arr[i][col] != '.' || arr[i][col] != 'S') {
                    flag1 = false;
                    break;
                }
            }
            boolean flag2 = true;
            for (int row = 0; row < m; row++) {
                if (arr[row][j] != '.' || arr[row][j] != 'S') {
                    flag2 = false;
                    break;
                }
            }
            //②判断s相邻的行列
            //左边列
            boolean flag3 = true;
            for (int row = 0; row < m; row++) {
                if (arr[row][(j - 1 + n) % n] != '.') {
                    flag3 = false;
                    break;
                }
            }
            //右边列
            boolean flag4 = true;
            for (int row = 0; row < m; row++) {
                if (arr[row][(j + 1) % n] != '.') {
                    flag4 = false;
                    break;
                }
            }
            //上边行
            boolean flag5 = true;
            for (int col = 0; col < n; col++) {
                if (arr[(i - 1 + m) % m][col] != '.') {
                    flag5 = false;
                    break;
                }
            }

            //下边行
            boolean flag6 = true;
            for (int col = 0; col < n; col++) {
                if (arr[(i + 1) % m][col] != '.') {
                    flag6 = false;
                    break;
                }
            }
            if(flag1||flag2||flag3||flag4||flag5||flag6)
                System.out.println("Yes");
            else
                System.out.println("No");
        }

    }
}
