package P04_CodingInterviews.P008_JumpFloor;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/7 10:15
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method2 {
    public int JumpFloor(int target) {
        if(target == 1)return 1;
        if(target == 2)return 2;
        int temp1 = 1,temp2 = 2,temp = 0;
        for(int i = 3; i <= target;i++){
            temp = temp1 + temp2;
            temp1 = temp2;
            temp2 = temp;

        }
        return temp;
    }
}
