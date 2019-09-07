package P04_CodingInterviews.P010_RectCover;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/7 10:34
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public int RectCover(int target) {
        if(target == 0) return 0;
        if(target == 1) return 1;
        if(target == 2) return 2;
        return RectCover(target-1)+RectCover(target-2);
    }
}
