package P03_Algorithm.A01_Recursion.A3_OtherProblem;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/8/20,22:11
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
//动态规划题，用递归只是展示解题思路
public class P02_LongestCommonSequence {
    public static void main(String [] args){
        String s1 = "abec";
        String s2 = "abcd";
        int res = LCS(s1,s2);
        System.out.println(res);
    }
    public static int LCS(String s1,String s2){
        if(s1.length() == 0 || s2.length() == 0) return 0;
        if(s1.charAt(0) == s2.charAt(0))
            return 1+ LCS(s1.substring(1),s2.substring(1));
        else
            return Math.max(LCS(s1.substring(1),s2),LCS(s1,s2.substring(1)));
    }
}
