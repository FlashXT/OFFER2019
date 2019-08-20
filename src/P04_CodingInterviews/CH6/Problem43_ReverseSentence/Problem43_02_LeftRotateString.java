package P04_CodingInterviews.CH6.Problem43_ReverseSentence;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/15 16:03;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/

/***********************************************************************
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟
 * 这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，
 * 字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 ***********************************************************************/
public class Problem43_02_LeftRotateString {
    public static  void main(String [] args){
     System.out.println(LeftRotateString("abcdefg",7));
    }
    public static String LeftRotateString(String str,int num){
        if(num >  str.length()) return "";
        if(num == str.length()) return str;
        String str1="",str2="";
        int i = 0;
        for(; i<num;i++){
            str1+=str.charAt(i);
        }
        for(; i<str.length();i++){
            str2+=str.charAt(i);
        }
        str = ReverseSentence(str1)+ReverseSentence(str2);
        str = ReverseSentence(str);
        return str;
    }
    public static String ReverseSentence(String  str){
        char [] ch = str.toCharArray();
        int start = 0;
        int end = ch.length-1;
        while(start < end){
            char temp = str.charAt(start);
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(ch);

    }
}
