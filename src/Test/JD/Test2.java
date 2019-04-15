package Test.JD;

import java.util.Arrays;
import java.util.Scanner;

public class Test2 {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();

        System.out.printf(SXH(m,n));


    }
    public static String SXH(int m,int n){
        String str ="";
        int j = 0,sum = 0,k=0;
        for(int i = m;i <= n;i++){
            j = i;
            sum=0;
            while(j>0){
                k = j%10;
                j = j/10;
                sum+=k*k*k;
            }
            if(sum == i)str+=i+" ";
        }
        if(str!="") return str;
        else return "no";

    }

}