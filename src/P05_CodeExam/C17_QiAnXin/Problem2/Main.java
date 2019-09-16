package P05_CodeExam.C17_QiAnXin.Problem2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/16,18:59
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Main {

    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        String str = "";
        while((str = scan.nextLine())!=null){
            int res = FixBug(str);
            System.out.println(res);
        }
    }
    public static int FixBug(String str){
        String [] arr = str.split(" ");
        Map<String, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i<arr.length;i++){
            if(!map.containsKey(arr[i])){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(arr[i],temp);
            }
            else{
                map.get(arr[i]).add(i);
            }
        }
        int res = 0;
        for(String key:map.keySet())
            if(map.get(key).size()>1)
                res+=map.get(key).size()*map.get(key).size();
        return res;
    }
}
