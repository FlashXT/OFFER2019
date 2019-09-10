package P04_CodingInterviews.P030_FindGreatestSumOfSubArray;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/10 16:35
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {

    //贪心法
    public int FindGreatestSumOfSubArray(int[] array) {
        int sum = Integer.MIN_VALUE;
        int temp = 0;
        for(int i = 0; i < array.length;i++){
            temp += array[i];

            sum  = sum < temp ? temp:sum;
            if(temp < 0){
                temp = 0;
            }
        }
        return sum;
    }
}
