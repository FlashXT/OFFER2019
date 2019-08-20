package P04_CodingInterviews.CH6.Problem43_ReverseSentence;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/15 15:26;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Problem43_01_ReverseSentence2 {
    public static void main(String [] args){
        System.out.println("I am a student.");
        System.out.println(ReverseSentence("I am a student."));
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
