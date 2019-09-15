package P04_CodingInterviews.P027_Permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/9,22:27
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method3 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if(str.length() == 0) return list;
        list = Permutation(str.toCharArray(),0,list);
        Collections.sort(list);
        return list;

    }
    private ArrayList<String> Permutation(char [] ch,int index,ArrayList<String> list) {
        if(index >= ch.length) {

            list.add(String.valueOf(ch));
        }
        Set set = new HashSet<>();
        for(int i = index; i < ch.length;i++){
            if(!set.contains(ch[i])){
                set.add(ch[i]);
                swap(ch,index,i);
                Permutation(ch,index+1,list);
                swap(ch,index,i);
            }

        }

        return list;
    }
    private static void swap(char[] ch,int index1,int index2){
        char temp = ch[index1];
        ch[index1] = ch[index2];
        ch[index2] = temp;
    }
}

