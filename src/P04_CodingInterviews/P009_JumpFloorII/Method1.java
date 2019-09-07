package P04_CodingInterviews.P009_JumpFloorII;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/7 10:19
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public int JumpFloorII(int target) {
        if(target <= 0)
            return -1;
        else if(target == 1)
            return 1;
        else
            return 2*JumpFloorII(target-1);
    }
}
