package P05_CodeExam.NetEase;

import java.util.Scanner;

public class Main2 {
    public static void main(String [ ]args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i = 0; i< n; i++){
            int k = (int)Math.random()*100;
            if(k%2 == 0)
                System.out.print("NO"+"\t");
            else
                System.out.print("YES"+"\t");
        }

    }
}
