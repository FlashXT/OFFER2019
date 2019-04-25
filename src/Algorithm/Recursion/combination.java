package Algorithm.Recursion;

/************************************************
 * 从n个球中，去除m个球，有多少种取法；
 ************************************************/
public class combination {
    public static void main(String [] args){
        int res = combination(5,1);
        System.out.println(res);
    }
    public static int combination(int n ,int m){
        if(n < m) return 0;
        if(n == m) return 1;
        if( m == 0) return 1;
        //将从 n 个球种取出m个球，分解为两种情况：
        //①从 n - 1 个球种取出 m个球；
        //②从 n - 1 个球种取出m-1个球，然后取 第 n 个球；
        return combination(n-1,m-1)+combination(n-1,m);
    }
}
