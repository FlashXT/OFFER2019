package P04_CodingInterviews.CH4.AbstractConcrete;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @Author: turboman
 * @Date: 2019/5/11 16:07
 * @Version 1.0
 */
public class Problem28_Permutation {
    public static void main(String [] args){
        String str = "abc";
        ArrayList<String>  list = Permutation(str);
        System.out.println(Arrays.toString(list.toArray()));
    }
    public static ArrayList<String> Permutation(String str) {
        char [] ch = str.toCharArray();
        ArrayList<String> list = new ArrayList<>();
        list = Permutation(ch,0,list);
        Collections.sort(list);
        return list;
    }
    public static ArrayList<String>  Permutation(char[] ch,int index,ArrayList<String> list){
        if(index >= ch.length){
            if(!list.contains(String.valueOf(ch)))
                list.add(String.valueOf(ch));
        }
        for(int i = index; i < ch.length;i++){
            swap(ch,i,index);                 //试探
            Permutation(ch,index+1,list);
            swap(ch,i,index);                 //回溯


        }
        return list;
    }
    public static void swap(char [] ch,int p1,int p2){
        char temp = ch[p1];
        ch[p1] = ch[p2];
        ch[p2] = temp;
    }
}
