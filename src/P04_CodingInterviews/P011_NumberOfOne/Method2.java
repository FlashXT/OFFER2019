package P04_CodingInterviews.P011_NumberOfOne;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/7 10:50
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
/*
    思路：把一个数减去1，再和元整数做与运算，会把整数最右边一个1变成0.
 */
public class Method2 {
    public int NumberOf1(int n) {
        int count = 0;

        while(n!=0){
            count++;
            n = (n - 1)&n;
        }
        System.out.println(count);
        return count;
    }
}
