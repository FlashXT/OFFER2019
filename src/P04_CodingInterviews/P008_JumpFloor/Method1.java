package P04_CodingInterviews.P008_JumpFloor;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/7 10:08
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {

    public int JumpFloor(int target) {
        if(target == 1)return 1;
        if(target == 2)return 2;
        return JumpFloor(target-1)+JumpFloor(target-2);
    }
}
