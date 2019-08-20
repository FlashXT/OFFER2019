package P03_Algorithm.A03_DynamicProgramming.DP03_IntegerBreak;

public class Method2 {
    //递归,对整数n进行分割（至少分割为两部分），可以获得的最大乘积
    public static int IntegerBreak(int num){
        if(num ==1)
            return 1;
        int res = -1;
        for(int i = num; i > 0;i--){
            //最大乘积，由(i,i*(num-i),i*intBreak2(num-i)))三者中最大的产生;
            res = Math.max(res,Math.max(i*(num-i),i* IntegerBreak(num-i)));
        }
        return res;

    }
}
