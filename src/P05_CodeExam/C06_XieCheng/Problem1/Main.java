package P05_CodeExam.C06_XieCheng.Problem1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/4 18:42
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Main {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        List<String> list = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            char ch = str.charAt(i);
            int j = str.length()-1;
            while(j > i&& str.charAt(j)!= ch)
                j--;
            list.add(str.substring(i,j+1));
            i = j+1;

        }
        Iterator<String> iter = list.iterator();
        StringBuilder sb = new StringBuilder();
        while(iter.hasNext())
            sb.append(iter.next().length()+",");
        System.out.println(sb.substring(0,sb.length()-1));
    }
}
