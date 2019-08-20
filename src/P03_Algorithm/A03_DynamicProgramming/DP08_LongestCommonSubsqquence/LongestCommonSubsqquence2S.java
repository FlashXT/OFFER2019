package P03_Algorithm.A03_DynamicProgramming.DP08_LongestCommonSubsqquence;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/14 15:14;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class LongestCommonSubsqquence2S {
    public static void main(String [] args){
        long time1 = System.currentTimeMillis();
        String str1 = "ABEDFGDSSADSADSADSADSADFGERTERTERT";
        String str2 = "ABCDFFFDGFDGEWRWETREWTERWGTFD";
        System.out.println(LCS(str1,str2));
        long time2 = System.currentTimeMillis();
        System.out.println((time2-time1)/1000);


    }
    public static int LCS(String str1,String str2){
        int [][] memo = new int[str1.length()][str2.length()];
        for(int i = 0; i< str1.length();i++){
            for(int j =0; j<str2.length();j++){
                memo[i][j]=-1;
            }
        }
        return LCS(str1, str1.length()-1,str2,str2.length()-1,memo);
    }
    private static int LCS(String str1,int index1,String str2, int index2,int[][]memo){
        if(index1 <=0 || index2 <= 0){
            if(index1 ==0&& index2 ==0){
                if(str1.charAt(0) == str2.charAt(0)){
                    memo[0][0] = 1;
                    return memo[0][0];
                }
            }
           return 0;
        }
        if(str1.charAt(index1) == str2.charAt(index2)){
            if(memo[index1-1][index2-1]==-1){
                memo[index1-1][index2-1] =LCS(str1,index1-1,str2,index2-1,memo);
            }
            memo[index1][index2] = 1+memo[index1-1][index2-1];
        }
        else{
            if(memo[index1-1][index2]==-1){
                memo[index1-1][index2] = LCS(str1,index1-1,str2,index2,memo);
            }
            if(memo[index1][index2-1]==-1){
                memo[index1][index2-1] = LCS(str1,index1,str2,index2-1,memo);
            }
            memo[index1][index2] = Math.max(memo[index1-1][index2],memo[index1][index2-1]);
        }

        return memo[index1][index2];
    }
}
