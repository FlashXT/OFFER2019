package P04_CodingInterviews.P007_Fibonacci;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/7 9:33
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public int Fibonacci(int n) {
        if(n == 0) return 0;
        int [] memo = new int[n+1];
        memo[0]=0;memo[1]=1;
        for(int i = 2; i <= n;i++)
            memo[i] = memo[i-1]+memo[i-2];
        System.out.println(memo[n]);
        return memo[n];
    }
}
