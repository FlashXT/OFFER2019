import java.util.*;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/20 20:07
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
import java.util.Arrays;
import java.util.Scanner;
public class Test2 {
    public static void main(String [] args){

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        List<String> list = new LinkedList<>();
        for(int i = 0 ;i < n;i++){
            list.add(scan.next());
        }
        Collections.sort(list);
        for(int i =0; i<m;i++){
            String str1 = scan.next();
            String str2 = scan.next();
            boolean flag = false;
            for(int j = 0; j < list.size();j++){
                String temp = list.get(j);
                if(isSubString(temp,str1)&&!isSubString(temp,str2)){
                    System.out.println(temp);
                    list.remove(temp);
                    flag = true;
                    break;
                }
            }
            if(!flag)
                System.out.println("-1");
        }
    }
    public static boolean isSubString(String str1,String str2){
        if(str1.length() < str2.length()) return false;
        if(str1.length() == str2.length()){
            for(int i = 0 ; i < str1.length();i++){
                if(str1.charAt(i) != str2.charAt(i))
                    return false;
            }
            return true;
        }
        return isSubString(str1.substring(1),str2)||isSubString(str1.substring(0,str1.length()-1),str2);

    }
}
