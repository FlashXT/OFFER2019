package P03_Algorithm.A01_Recursion.OtherProblem;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/8/20,22:11
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
//动态规划题，用递归只是展示解题思路
public class P03_LongestCommonSubString {
    private  static  int res = 0;
    public static void main(String [] args){
        String s1 = "aefc";
        String s2 = "abedc";
        LCString(s1,s2,0);
        System.out.println(res);
    }
    public static void LCString(String s1,String s2,int len){
        if(s1.length() == 0 || s2.length() == 0) return ;
        if(s1.charAt(0) == s2.charAt(0)){
            len+=1;
            LCString(s1.substring(1),s2.substring(1),len);

        }
        else{
            //当前位不相等，则比较res与len的大小，并赋值后将len置为0；
            res = res < len ? len:res;
            len = 0;
            LCString(s1.substring(1),s2,len);
            LCString(s1,s2.substring(1),len);
        }
    }
}
