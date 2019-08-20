package P04_CodingInterviews.CH3;

public class Problem11_Power {
    public static void main(String [] args){
        System.out.println(power(-12,5));
    }
    public static double power(double base,int exp){
        //①判断base是否等于0，计算机无法准确表示小数，实现compare方法
        if(compare(base,0.0) && exp < 0)
            return -1;
        int expabs = exp > 0? exp:-exp;
        double res= PowerWithUnsignedExp(base,expabs);

        return exp > 0?res:1.0/res;

    }
    public static double PowerWithUnsignedExp(double base, int exp){
        double res =1;
        while(exp>0){
            res *= base;
            exp--;
        }
        return res;
    }
    //②效率提升，a^N = a^(n/2)*a^(n/2)，n为偶数；
    //            = a^((n-1)/2)*a^((n-1)/2)*a,n为奇数
    public static double PowerWithUnsignedExp2(double base, int exp){
        if(exp == 0)
            return 1;
        //③移位操作比除法快；
        double res =  PowerWithUnsignedExp2(base,exp>>1);
        res *= res;

        //④与1进行&操作，位运算判断是不是奇数
        if((exp&0x1)==1)
           res *=base;
        return res;
    }


    public static boolean compare(double a,double b){
        double error = a -b;
        if(error > 0.000001 && error < -0.000001)
            return false;
        else{
            return true;
        }
    }
}
