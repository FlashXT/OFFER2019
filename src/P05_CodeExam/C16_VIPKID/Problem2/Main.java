package P05_CodeExam.C16_VIPKID.Problem2;

import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/16,15:47
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Main {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] temp = new int[n];
        IntegerBack(n,temp,0);
    }
    public static void IntegerBack(int target,int[] temp,int len){

        if(target ==  0){
            for(int i = 0; i < len-1;i++){
                System.out.print(temp[i]+"+");
            }
            System.out.print(temp[len-1]+"\n");
        }
        int start = len-1 < 0? 1:temp[len-1];
        for(int i = start;  i<= target;i++){
            temp[len] = i;
            IntegerBack(target-i,temp,len+1);
        }
    }
}
