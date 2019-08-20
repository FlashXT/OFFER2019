package Test.Test360;

import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/8/15,20:46
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Main1 {
    public static  void main(String [ ]args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int [][] grid = new int[n][m];
        for(int i = 0;i < n;i++){
            for(int j = 0; j < m;j++){
                grid[i][j] = scan.nextInt();
            }
        }
        System.out.println(surfaceArea(grid));
    }
    public static int surfaceArea(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] != 0)
                {
                    sum += grid[i][j]*6;
                    // Z axis
                    sum -= 2*(grid[i][j] -1);

                    // Y axis
                    if(i < grid.length -1)
                    {
                        sum -= 2*Math.min(grid[i][j], grid[i +1][j]);
                    }

                    // X axis
                    if(j < grid[0].length -1)
                    {
                        sum -= 2*Math.min(grid[i][j],grid[i][j+1]);
                    }
                }
            }
        }

        return sum;
    }
}
