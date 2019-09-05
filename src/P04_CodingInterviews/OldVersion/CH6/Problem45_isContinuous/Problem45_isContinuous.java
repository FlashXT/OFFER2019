package P04_CodingInterviews.OldVersion.CH6.Problem45_isContinuous;

import java.util.Arrays;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/5/15 20:14
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Problem45_isContinuous {
    public static void main(String [] args){
        int [] nums = {1,0,3,5,0};
        System.out.println(isContinuous(nums));
    }
    public static Boolean isContinuous(int [] nums){
        if(nums.length  == 0) return false;
        Arrays.sort(nums);
        int numOfZero = 0;
        int numOfGap = 0;
        for(int i  =0; i <nums.length;i++){
            if(nums[i] ==0)
                numOfZero++;
        }
        for(int i = 1; i < nums.length;i+=1){

            if(nums[i-1]!=0){
              if(nums[i] - nums[i-1] == 0)
                return false;
              numOfGap+=nums[i] - nums[i-1]-1 ;
            }
        }
        return numOfGap <= numOfZero ? true:false;

    }
}
