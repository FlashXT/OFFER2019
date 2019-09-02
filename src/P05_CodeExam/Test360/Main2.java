package P05_CodeExam.Test360;

import java.util.*;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/8/15,20:00
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
//序列重组
public class Main2 {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        Map<Integer,Integer> a = new HashMap<>();
        Map<Integer,Integer> b = new HashMap<>();
        for(int i = 0 ;i < n; i++){
            int n1 = scan.nextInt();
            a.put(n1,a.getOrDefault(n1,0)+1);
        }
        for(int i = 0 ;i < n; i++){
            int n2 = scan.nextInt();
            b.put(n2,b.getOrDefault(n2,0)+1);
        }
        StringBuilder sb=  new StringBuilder();
        for(int k = 0; k < n;k++){
            boolean flag = false;
            for(int i = m-1;i >=0;i--){
                for(int key:a.keySet()){
                    int num = (i-key+m)%m;
                    if(b.containsKey(num) && b.get(num) > 0){
                        b.replace(num,b.get(num)-1);
                        a.replace(key,a.get(key)-1);
                        sb.append(i+" ");
                        flag = true;
                        break;
                    }
                }
                if(flag)
                    break;
            }
        }
        System.out.println(sb.toString());
    }

}
