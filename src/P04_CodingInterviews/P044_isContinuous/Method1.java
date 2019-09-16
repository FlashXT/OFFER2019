package P04_CodingInterviews.P044_isContinuous;

import java.util.Arrays;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/16,20:31
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public boolean isContinuous(int [] numbers) {
        if(numbers.length==0)return false;
        Arrays.sort(numbers);
        int count = 0;
        int gap = 0;
        for(int i = 0 ; i < numbers.length-1;i++){
            if(numbers[i]==0)
                count++;
            else{
                if(numbers[i+1] == numbers[i] )
                    return false;
                gap += numbers[i+1]-numbers[i]-1;
            }
        }
        if(gap <= count)
            return true;
        else
            return false;
    }
}
