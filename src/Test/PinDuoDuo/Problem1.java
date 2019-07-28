package Test.PinDuoDuo;

import java.util.Arrays;
import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/7/28 15:03
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Problem1 {
    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        String arra = scan.nextLine();
        String [] temp = arra.split(" ");
        int [] a = new int[temp.length];
        for(int i = 0; i<a.length;i++){
            a[i] = Integer.valueOf(temp[i]);
        }
        String arrb = scan.nextLine();
        String [] temp2 = arrb.split(" ");
        int [] b = new int[temp2.length];
        for(int i = 0; i<b.length;i++){
            b[i] = Integer.valueOf(temp2[i]);
        }
        int pos = -1;
        for(int i =1 ; i < a.length;i++){
            if(a[i] < a[i-1]){
                pos = i;
                break;
            }
        }
//        Arrays.sort(b);
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < b.length;i++){
            if(b[i] > a[pos-1] && b[i] < a[pos+1]){
                max = max > b[i] ? max:b[i];
            }

        }
        if(max != Integer.MIN_VALUE){
            a[pos] = max;
            for(int i = 0; i< a.length;i++)
                System.out.print(a[i]+" ");
        }
        else
            System.out.println("NO");

    }
}
