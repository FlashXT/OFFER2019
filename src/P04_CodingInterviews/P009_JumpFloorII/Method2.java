package P04_CodingInterviews.P009_JumpFloorII;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/7 10:19
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method2 {
    public int JumpFloorII(int target) {
        if(target == 1)
            return 1;
        return 1<<(target-1);
    }
}
