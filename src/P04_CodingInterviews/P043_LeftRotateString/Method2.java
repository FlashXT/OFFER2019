package P04_CodingInterviews.P043_LeftRotateString;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/16,15:35
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method2 {
    //YX = (X^TY^T)^T
    public String LeftRotateString(String str,int n) {
        if(n > str.length()) return str;
        String substr1 = str.substring(0,n);
        substr1 = Reverse(substr1);
        String substr2 = str.substring(n);
        substr2 = Reverse(substr2);
        String res = Reverse(substr1+substr2);
        System.out.print(res);
        return res;
    }
    public static String Reverse(String str){
        if(str == null) return str;
        char [] ch = str.toCharArray();
        for(int i = 0 ; i< ch.length/2;i++){
            char temp = ch[i];
            ch[i] = ch[ch.length-1-i];
            ch[ch.length-1-i] = temp;
        }
        return String.valueOf(ch);
    }
}
