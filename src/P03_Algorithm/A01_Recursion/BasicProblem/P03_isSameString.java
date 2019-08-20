package P03_Algorithm.A01_Recursion.BasicProblem;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/8/20,11:15
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class P03_isSameString {
    public static void main(String [] args){
        String s1 = "abc";
        String s2 = "bcd";
        System.out.println(isSameString(s1,s2));

    }
    public static boolean isSameString(String s1,String s2){
        if(s1.length() != s2.length())     return false;
        //执行到此处表明s1.length() = s2.length(),此时若
        //s1.length() = 0，则s1.length() = s2.length() =0，返回true;
        if(s1.length() == 0) return true;
        if(s1.charAt(0) == s2.charAt(0))
            return isSameString(s1.substring(1),s2.substring(1));
        else
            return false;

    }
}
