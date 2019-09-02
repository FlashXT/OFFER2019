package P05_CodeExam.C03_KuaiShou;

import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/8/25,16:14
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Main4 {
    public static void main(String [ ]args){
        Scanner scan = new Scanner(System.in);
        String equa = scan.next();
        equa = equa.replace("*","");
        System.out.println(equa);
        solveEquation(equa);
    }
    public static void solveEquation(String equation) {
        String[] lr = equation.split("=");
        int lhs = 0, rhs = 0;
        for (String x: lr[0].split("(?=\\+)|(?=-)")) {
            if (x.indexOf("X") >= 0) {

                lhs += Integer.parseInt(f(x));
            } else
                rhs -= Integer.parseInt(x);
        }
        for (String x: lr[1].split("(?=\\+)|(?=-)")) {
            if (x.indexOf("X") >= 0)
                lhs -= Integer.parseInt(f(x));
            else
                rhs += Integer.parseInt(x);
        }
        if (lhs == 0)
            System.out.println(-1);
        else{
            double res = rhs*1.0 / lhs;
            String [] str = String.valueOf(res).split("\\.");
            if(str[1].equals("0") && str[0].charAt(0)!='-'&& str[0].charAt(0)!='0')
                System.out.println(str[0]);
            else
                System.out.println(-1);
        }

    }

    public static String f(String x) {
        if (x.length() > 1 && x.charAt(x.length() - 2) >= '0' && x.charAt(x.length() - 2) <= '9')
            return x.replace("X", "");
        return x.replace("X", "1");
    }

}


