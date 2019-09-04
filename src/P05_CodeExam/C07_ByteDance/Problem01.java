package P05_CodeExam.C07_ByteDance;

import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/6/1 20:09;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Problem01 {
    public static  int count = 0;
    public static void main(String [] args){
        Scanner scan  = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int h = (int)(-1+Math.sqrt(1+8*(a+b)))/2;
        int [] arr = new int[h];
        AddDivision(b,h,arr,0);
        System.out.println(count);
    }
    public static void AddDivision(int num,int k,int [] arr,int pos){

        if(k <= 0) {
            int sum = 0;
            for(int i = 0; i<pos;i++){
                System.out.print(arr[i]+"\t");
            }
            System.out.println();
            if(sum == num)count++;
            return ;
        }
        for(int i =k; i >0;i--){
            if( pos > 0 && i > arr[pos-1]) continue;
            arr[pos] = i;
            AddDivision(num,k - i,arr,pos+1); //试探
        }

    }

}
