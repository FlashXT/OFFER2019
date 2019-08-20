package P05_CompanyCodeTest.JD;

import java.util.Scanner;

public class Test {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int a1 = scan.nextInt();
        int a2 = scan.nextInt();
        int b1 = scan.nextInt();
        int b2 = scan.nextInt();
        System.out.printf("%.2f",sum(a1,a2));
        System.out.printf("\n%.2f",sum(b1,b2));

    }
    public static double sum(double a,int b){
        double sum = 0;
        for(int i =1 ;i<=b;i++){
            sum+=a;
            a = Math.sqrt(a);
        }
        return sum;
    }
}
