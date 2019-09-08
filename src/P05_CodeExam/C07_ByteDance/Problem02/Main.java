package P05_CodeExam.C07_ByteDance.Problem02;

import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/8 18:53
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Main {
    public static void main(String [] args){
        Scanner scan  = new Scanner(System.in);
        int n = scan.nextInt();
        int [] arr = new int [n];
        for(int i = 0; i < n;i++)
            arr[i] = scan.nextInt();
        int maxtimes = -1;
        int res = arr[0];
        for(int i = 0 ;i < n-1;i++){
            int max = arr[i+1];
            int times = 0;
            for(int j = i+1;j < n;j++){
                if(arr[j] > arr[i])
                    break;
                if(max <= arr[j] && arr[j] <= arr[i])
                    times ++;
                else
                    max = max < arr[j] ? arr[j]:max;
            }
            if(times > maxtimes){
                maxtimes = times;
                res = arr[i];
            }

        }
        System.out.println(res);
    }
}
