package P05_CodeExam.C04_DangDang.Problem1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/2,18:46
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
/*
 *25525511135
 */
public class Main {
    static List<String> ans = new ArrayList<>();
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        ans.clear();
        restoreIpAddresses(str,4,"");
        Iterator<String>  iter = ans.iterator();
        StringBuilder res = new StringBuilder();
        while(iter.hasNext()){
            res.append(iter.next()+",");
        }
        System.out.println(res.substring(0,res.length()-1));
    }
    private static void restoreIpAddresses(String s,int len,String res) {
        if(len == 0){
            if(s.length() ==0){
                res = res.substring(0,res.length()-1);
                ans.add(res);
            }
            return ;
        }
        //每一段最多3个数字，若该段以0开头，只能是一个数字
        int last = Math.min(3,s.length());
        if(last > 0 && s.charAt(0) == '0')
            last = 1;
        for(int i = 1;i <= last;i++){
            if(i < last || (i == last && Integer.valueOf(s.substring(0,last))<=255)){
                res+=s.substring(0,i)+".";
                restoreIpAddresses(s.substring(i),len-1,res);
                res=res.substring(0,res.length()-i-1);
            }
        }

    }
}
