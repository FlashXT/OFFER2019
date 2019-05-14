package Algorithm.DynamicProgramming.DP08_LongestCommonSubsqquence;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/14 15:14;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class LongestCommonSubsqquence1R {
    public static void main(String [] args){
        long time1 = System.currentTimeMillis();
        String str1 = "ABEDFGDSSADSADSADSADSADFGERTERTERT";
        String str2 = "ABCDFFFDGFDGEWRWETREWTERWGTFD";
        System.out.println(LCS(str1,str2));
        long time2 = System.currentTimeMillis();
        System.out.println((time2-time1)/1000);


    }
    public static int LCS(String str1,String str2){
        return LCS(str1, str1.length()-1,str2,str2.length()-1,0);
    }
    private static int LCS(String str1,int index1,String str2, int index2,int len){
        if(index1 <0 || index2 < 0){
            return len;
        }
        if(str1.charAt(index1) == str2.charAt(index2)){
            len =1+LCS(str1,index1-1,str2,index2-1,len);
        }
        else{
            int len1 = LCS(str1,index1-1,str2,index2,len);
            int len2 = LCS(str1,index1,str2,index2-1,len);
            len = Math.max(len1,len2);
        }

        return len;
    }
}
