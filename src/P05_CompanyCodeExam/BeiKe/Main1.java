package P05_CompanyCodeExam.BeiKe;


import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/8/10 18:44
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Main1 {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        int res = 0;
        for(int i = 1; i< 10000;i++){
            if(Math.log(i)+0.6 >k){
                System.out.println(i);
                break;
            }

        }
        System.out.println();



    }
}
