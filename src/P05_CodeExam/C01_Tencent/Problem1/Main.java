package P05_CodeExam.C01_Tencent.Problem1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/1,19:54
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
/*input:
 *1
 *6
 *1 2 3 4 5 6
 * output:
 * YES
 */
public class Main {
    public static  void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        for(int q = 0;q < m;q++){
            int n = scan.nextInt();
            int [] arr = new int[n];
            for(int i= 0; i< n;i++)
                arr[i] = scan.nextInt();
            del(arr);
        }
    }
    public static void del(int [] arr){
        if(arr.length%2 ==1){
            System.out.println("NO");
            return ;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i< arr.length;i++)
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        int max = Integer.MIN_VALUE;
        for(Integer key:map.keySet()){
            max = max < map.get(key)?map.get(key):max;
        }
        if(max > arr.length/2)
            System.out.println("NO");
        else
            System.out.println("YES");
    }
}
