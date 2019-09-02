package P03_Algorithm.A01_Recursion.A04_StringPatternMatching;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/2,16:01
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class P01_subStrMatch {
    public static void main(String [] args){
        System.out.println(subStrMatch("abcd","e"));
    }
    //暴力匹配，时间复杂度O(m*n)
    public static int subStrMatch(String str,String sub){
        for(int i = 0 ; i< str.length();i++){
            boolean flag = false;
            for(int j = 0; j < sub.length();j++){
                if(str.charAt(i+j)!=sub.charAt(j)){
                    flag = true;
                    break;
                }
            }
            if(!flag) return i;
        }
        return -1;
    }
    //KMP
//    public static int KMP(){
//
//    }
}
