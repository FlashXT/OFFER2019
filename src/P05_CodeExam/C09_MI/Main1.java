import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/11,19:35
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Main1 {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        String [] str = scan.nextLine().split(" ");
        int sum = 0;
        int temp = 0;
        for(int i = 0; i< str.length;i++){
            temp += Integer.valueOf(str[i]);
            sum = sum < temp?temp:sum;
            if(temp  < 0)
                temp = 0;
        }
        System.out.print(sum);

    }
}
