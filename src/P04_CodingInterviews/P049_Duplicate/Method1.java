package P04_CodingInterviews.P049_Duplicate;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/17,20:31
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        boolean [] times = new boolean[length];
        for(int i = 0 ;i < length;i++){
            if(!times[numbers[i]])
                times[numbers[i]]=true;
            else{
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }
}
