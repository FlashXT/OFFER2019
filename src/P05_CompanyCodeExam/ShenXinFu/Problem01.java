package P05_CompanyCodeExam.ShenXinFu;

import java.util.*;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/31 20:34;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Problem01 {
    public static void main(String [] args){
        String str = "3!hello wor\tld!OVER";

        splitWord(str);
    }
    public static  void splitWord(String str){
        ArrayList<String> res = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        set.add('-');set.add(' ');set.add('-');
        set.add(',');set.add('!');set.add('\t');
        set.add('\'');

        int j = 0;
        for(int i = 0; i < str.length();i++){
            if(set.contains(str.charAt(i))){
//                if(str.charAt(i) =='\''){
//                    res.add(str.substring(j,i)+"\\'");
//                }
//                else if(str.charAt(i) =='\t'){
//                    res.add(str.substring(j,i)+"\\t");
//                }
//                else {
                    res.add(str.substring(j,i+1));
//                }
                j = ++i;
            }
        }
        res.add(str.substring(j));
        StringBuilder sb = new StringBuilder();
        String temp;
        for(int i = 0; i < res.size();i++){

            temp = res.get(i).toLowerCase();
            if(!set.contains(temp.charAt(0)) && !(temp.charAt(0)>='0' && temp.charAt(0) <='9'))
                temp = (char)(temp.charAt(0)+('A'-'a'))+temp.substring(1);
            sb.append(temp);
        }
        System.out.println(sb);

    }
}
