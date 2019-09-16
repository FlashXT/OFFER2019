package P04_CodingInterviews.P046_BitOpSum;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/16,21:55
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public int Sum_Solution(int n) {
        int ans = n;
        boolean temp = (ans!=0) &&((ans+=Sum_Solution(n-1))!=0);
        return ans;
    }
}
