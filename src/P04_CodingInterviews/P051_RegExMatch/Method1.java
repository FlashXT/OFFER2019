package P04_CodingInterviews.P051_RegExMatch;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/17,21:02
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
/*
    链接：https://www.nowcoder.com/questionTerminal/45327ae22b7b413ea21df13ee7d6429c?f=discussion
    来源：牛客网

    当模式中的第二个字符不是“*”时：
    1、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。
    2、如果 字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。

    而当模式中的第二个字符是“*”时：
    如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。如果字符串第一个字符跟模式第
    一个字符匹配，可以有3种匹配方式：
    1、模式后移2字符，相当于x*被忽略；
    2、字符串后移1字符，模式后移2字符；
    3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；
 */
public class Method1 {
    public boolean match(char[] str, char[] pattern)
    {
        return match(str,0,pattern,0);
    }
    private boolean match(char[] str,int index1 ,char[] pattern,int index2){
        if(index1== str.length && index2 == pattern.length){
            return true;
        }
        if(index1 < str.length && index2 == pattern.length){
            return false;
        }

        if(index2 < pattern.length-1 && pattern[index2+1]=='*'){
            if(index1 < str.length && (pattern[index2]==str[index1]||pattern[index2]=='.')){
                boolean res1 = match(str,index1,pattern,index2+2);
                boolean res2 = match(str,index1+1,pattern,index2);
                return res1 || res2;
            }else{
                return match(str,index1,pattern,index2+2);
            }

        }else{
            if(index1 < str.length  &&(str[index1] == pattern[index2] || pattern[index2]=='.'))
                return match(str,index1+1,pattern,index2+1);
            else
                return false;
        }
    }
}
