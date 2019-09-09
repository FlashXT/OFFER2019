package P04_CodingInterviews.P027_Permutation;

import java.util.ArrayList;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/9,22:27
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if(str.length() == 0) return list;
        list = Permutation(str.toCharArray(),0,list);
        return list;

    }
    public ArrayList<String> Permutation(char [] ch,int index,ArrayList<String> list) {
        if(index >= ch.length){
            if(!list.contains(String.valueOf(ch))){
                list.add(String.valueOf(ch));
            }
            for(int i = index; i < ch.length;i++){
                swap(ch,index,i);
                Permutation(ch,index+1,list);
                swap(ch,index,i);
            }

        }
        return list;
    }
    public static void swap(char[] ch,int index1,int index2){
        char temp = ch[index1];
        ch[index1] = ch[index2];
        ch[index2] = temp;
    }
}

