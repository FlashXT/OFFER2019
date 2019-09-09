package P04_CodingInterviews.P027_Permutation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/9 23:35
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method2 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if(str.length() == 0) return list;
        Map<Character,Integer> map = new HashMap<>();

        for(int i = 0; i < str.length();i++){
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
        }
        char [] ch = new char[map.size()];
        int [] count = new int[map.size()];
        int i = 0;
        for(char key :map.keySet()){
            ch[i] = key;
            count[i++] = map.get(key);

        }
        list = Permutation(ch,count,"",list);
        return list;

    }
    public static  ArrayList<String> Permutation(char[] ch,int[]count,String res,ArrayList<String> list){
        if(isAllUsed(count)){
            list.add(res);
            return list;
        }
        for(int i = 0; i< ch.length;i++){
            if(count[i]!=0){
                res+=ch[i];
                count[i]--;
                Permutation(ch,count,res,list);
                count[i]++;
                res = res.substring(0,res.length()-1);
            }
        }
        return list;
    }
    public static boolean isAllUsed(int []count){
        for(int i = 0; i < count.length;i++){
            if(count[i]!=0)
                return false;
        }
        return true;
    }
}
