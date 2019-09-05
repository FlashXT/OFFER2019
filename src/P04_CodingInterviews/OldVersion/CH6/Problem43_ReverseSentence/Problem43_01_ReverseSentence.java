package P04_CodingInterviews.OldVersion.CH6.Problem43_ReverseSentence;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/15 15:26;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Problem43_01_ReverseSentence {
    public static void main(String [] args){
        System.out.println("I am a student.");
        System.out.println(ReverseSentence("I am a student.",0));
    }
    public static String ReverseSentence(String str){
        if(str==null||str.trim().equals(""))return str;
        String [] strarr = str.split(" ");
        String res = ReverseSentence(strarr,0);
        return res;
    }
    //只翻转单词的顺序
    public static String ReverseSentence(String [] str,int index){
        if(index == str.length-1){
            return str[index];
        }
        return ReverseSentence(str,index+1)+" "+str[index];

    }
    //将一个句子完全翻转
    public static String ReverseSentence(String str,int index){
        if(index == str.length()-1){
            return ""+str.charAt(index);
        }
        return ReverseSentence(str,index+1)+str.charAt(index);

    }
}
