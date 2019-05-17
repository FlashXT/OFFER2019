package TencentOffer.CH8.Problem53_RegularMatch;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/17 16:32;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/

/**********************************************************************
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字
 * 符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和
 * "ab*a"均不匹配;
 **********************************************************************/
public class RegularMatch {

    public static void main(String [] args){
        char [] ch = "".toCharArray();
        char [] p =  ".*".toCharArray();
        System.out.println(match(ch,p));


    }
    public static boolean match(char[] str, char[] pattern){
        if(str == null && pattern == null) return false;
        return match(str,pattern,0,0);
    }
    private static boolean match(char[] str,char[] pattern,int index1,int index2){
        if(index1 >= str.length && index2 >= pattern.length)
            return true;
        if(index1 <  str.length&&index2 >= pattern.length)
            return false;
        if(index2 + 1 < pattern.length && pattern[index2+1] =='*'){
            if(index1 < str.length && str[index1] == pattern[index2] ||
                    index1 < str.length&&pattern[index2]=='.'){

                return  match(str,pattern,index1,index2+2)||            //*前字符出现0次
                        match(str,pattern,index1+1,index2+2)||      //*前字符出现1次
                        match(str,pattern,index1+1,index2);             //*前字符出现多次
            }
            else
                return match(str,pattern,index1,index2+2);
        }
        else{

            if(index1 < str.length && str[index1] == pattern[index2] ||
                    index1< str.length&&pattern[index2]=='.')
                return match(str,pattern,index1+1,index2+1);
            else
                return false;
        }
    }

}
