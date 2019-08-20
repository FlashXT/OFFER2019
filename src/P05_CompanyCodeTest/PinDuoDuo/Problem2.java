package P05_CompanyCodeTest.PinDuoDuo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/7/28 15:25
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Problem2 {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        String [] str =  scan.nextLine().split(" ");
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length;i++){

            map.put(str[i],map.getOrDefault(str[i],0)+1);
        }
        int[] count = new int[map.keySet().size()];
        int m = 0;
        for(String key : map.keySet()){
            count[m++] = map.get(key);
        }
        for(int k = 0; k < str.length;k++){
            count[k]--;
            if(isOK(str,count,str[k],1))
            {
                System.out.println("true");
                return;
            }
            count[k]++;
        }
        System.out.println("false");
        return ;
    }
    public static boolean isOK(String [] str,int [] count,String res,int index){
        if(index == str.length){
            if(res.charAt(res.length()-1) == res.charAt(0))
                return true;
            else
                return false;
        }
        int i = 0;
        for(; i< str.length;i++){
            if(count[i]>0 && str[i].charAt(0) == res.charAt(res.length()-1)){
                res=res + str[i];
                count[i]--;
                if(isOK(str,count,res,index+1)){
                    break;
                }
            }

        }
        if(i==str.length) return false;
        else
            return true;

    }

}
