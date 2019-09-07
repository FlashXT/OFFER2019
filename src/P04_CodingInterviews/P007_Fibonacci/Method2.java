package P04_CodingInterviews.P007_Fibonacci;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/7 9:33
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method2 {
    public int Fibonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int temp1 = 0,temp2 = 1,temp = 0;
        for(int i = 2; i <= n;i++){
            temp = temp1+temp2;
            temp1 = temp2;
            temp2 = temp;
        }
        System.out.println(temp);
        return temp;

    }
}
