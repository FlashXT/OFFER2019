package P04_CodingInterviews.P002_BlankReplace;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/5 14:57
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
/*
   题目：请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.
       则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Main {
    public static void main(String [] args){
        StringBuffer sb = new StringBuffer("We Are Happy.");
        new Method1().replaceSpace(sb);
    }
}
