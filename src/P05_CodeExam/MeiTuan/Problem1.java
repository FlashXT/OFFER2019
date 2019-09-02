package P05_CodeExam.MeiTuan;

import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/8/31 20:04
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Problem1 {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n;i++)
            arr[i] = scan.nextInt()/100;
        int sum = 0;
        for(int i = 0; i < n;i++){
            int temp = sum;
            for(int j  = i + 1; j < i+arr.length;j++ )
            {
                if(j < arr.length && arr[j] <arr[i]+180){
                    sum++;
                }
                else if(j > arr.length){
                    if((arr[j%arr.length]+360) <(arr[i]+180))
                        sum++;
                }
                else
                    break;
            }
            if(temp != sum)sum--;
        }
        System.out.println(sum);
    }
}
