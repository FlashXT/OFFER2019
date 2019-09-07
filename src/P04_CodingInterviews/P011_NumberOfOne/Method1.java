package P04_CodingInterviews.P011_NumberOfOne;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/7 10:50
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public int NumberOf1(int n) {
        int count = 0;
        int flag = 1;
        while(flag != 0){
            if((n & flag) != 0){
                count++;
            }
            flag = flag <<1;
        }
        System.out.println(count);
        return count;
    }
}
