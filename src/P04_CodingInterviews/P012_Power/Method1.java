package P04_CodingInterviews.P012_Power;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/7 11:12
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public double Power(double base,int exponent){
        if(exponent < 0)
            return 1/PowerPos(base,-exponent);
        else
            return PowerPos(base,exponent);
    }
    public double PowerPos(double base,int exponent){
        if(exponent == 0) return 1;
        if(exponent == 1)
            return base;
        if((exponent&1) == 0)
            return PowerPos(base,exponent/2)*PowerPos(base,exponent/2);
        else
            return base*PowerPos(base,exponent/2)*PowerPos(base,exponent/2);
    }
}
