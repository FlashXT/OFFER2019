package P05_CodeExam.C03_KuaiShou;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/8/25,17:39
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Main1 {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        List<String> vlist = new ArrayList<>();
        List<String> plist = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for(int i = 0; i< m ; i++){
            String str = scan.next();
            if(i > n){
                if(str.charAt(0)=='V')
                    vlist.add(str);
                else
                    plist.add(str);
            }

            list.add(str);
        }
        int i = 0;
        for(; list.get(i).charAt(0)!='P';i++){
            String str = list.get(i);
            if(str.charAt(0)=='V')
                vlist.remove(str);
            else
                plist.remove(str);
        }
        plist.remove(0);
        int key = i+1;
        for(;i+1 < m;i++)
            list.remove(key);
        int count=1;
        while(!vlist.isEmpty()||count%n==0){
            if(count%n != 0){
                list.add(key++,vlist.get(0));
                vlist.remove(0);
            }else{
                list.add(key++,plist.get(0));
                plist.remove(0);

            }
            count++;
            if(plist.isEmpty()){
                for(int c= 0; c < vlist.size();c++)
                    list.add(vlist.get(c));
                break;
            }
        }
        System.out.println(list.size());
        Iterator<String> iter = list.iterator();
        while(iter.hasNext())
            System.out.println(iter.next());

    }
}
