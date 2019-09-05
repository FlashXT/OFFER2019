package P04_CodingInterviews.OldVersion.CH2;

import java.text.NumberFormat;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/18 18:40;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
//牛顿法开方，计算方程的近似解，使用泰勒公式
public class computeSqrt {
    public static void main(String [] args){
        System.out.println(Sqrt(998,14));
    }
    public static double Sqrt(double num , int error){
        if(num < 0 || error < 0) return -1;
        double x0 = 10;
        while(Math.abs(x0*x0-num)>=Math.pow(10,-error)){

            x0 = x0-(x0*x0-num)/(2*x0);
//            System.out.println(x0);
        }
        // 设置数的小数部分所允许的最大位数。
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(error);
        x0 = Double.valueOf(nf.format(x0));

        return x0;
    }
}
