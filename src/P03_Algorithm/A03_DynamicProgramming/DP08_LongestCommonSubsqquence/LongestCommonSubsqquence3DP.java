package P03_Algorithm.A03_DynamicProgramming.DP08_LongestCommonSubsqquence;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/14 15:14;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class LongestCommonSubsqquence3DP {
    public static void main(String [] args){

        String str1 = "AGD";
        String str2 = "ABC";

        System.out.println(LCS(str1,str2));

    }

    //动态规划,memo[i][j]表示str1[0~i-1],str2[0~j-1]时，的最长公共子串
    public static int LCS(String str1,String str2){
        int m = str1.length(),n = str2.length();
        int [][] memo = new int[m+1][n+1];

        for(int i = 1; i<=m;i++){
            for(int j =1; j<=n;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    memo[i][j] = 1+memo[i-1][j-1];
                }
                else {
                    memo[i][j]= Math.max(memo[i-1][j],memo[i][j-1]);
                }

            }
        }
        for(int i = 0; i<memo.length;i++){
            for(int j =0; j<memo[i].length;j++)
                System.out.printf("%d\t",memo[i][j]);
            System.out.println();
        }
        return memo[m][n];
    }

}
