package P05_CodeExam.C02_PinDuoDuo.Problem5;

import java.util.Arrays;
import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/1,15:40
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Main5 {
    public static void main(String [ ]args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] arr = new int [n];
        for(int i = 0 ; i< n;i++)
            arr[i] = scan.nextInt();
        Arrays.sort(arr);
        int max = arr[arr.length-1];
        int [] sum = new int[max+1];
        int s = 1;
        for(int i = 2; i < max+1;i++){

            sum[i] = partsum(n-search(arr,i));
            s+=sum[i];
        }
        int res = 1;
        for(int i = 2; i < max+1;i++)
            res+=i*sum[i];
        System.out.printf("%.2f",res*1.0/s);

    }
    public static int partsum(int k){
        int sum = 0;
        for(int i =1 ;i <=k;i++){
            sum+=part(k,i);
        }
        return sum;
    }
    public static int part(int k,int m){
        int res = 1;
        for(int i = k ; i  >= k-m+1;i--)
            res*=i;
        for(int i =1 ;i<= m;i++)
            res/=i;
        return res;
    }
    public static int search(int [] arr ,int target){
        for(int i = 0; i< arr.length;i++) {
            if (arr[i] >= target)
                return i-1;
        }
        return 0;
    }
}
