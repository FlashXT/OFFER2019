package P04_CodingInterviews.P031_NumberOf1Between1AndN;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/10 17:19
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int sum = 0;
        int num;
        for(int i = 1 ; i<=n;i++){
            num = i;
            while(num > 0){
                if(num %10 == 1)
                    sum++;
                num = num /10;
            }
        }
        return sum;
    }
}
