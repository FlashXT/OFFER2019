package P04_CodingInterviews.P066_cutRope;

import org.omg.PortableInterceptor.INACTIVE;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/19,21:08
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    static  int res = Integer.MIN_VALUE;
    public int cutRope(int target) {
        int [] temp = new int[target];
        res = Integer.MIN_VALUE;
        cutRope(target,temp,0);
        return res;

    }
    private void cutRope(int target,int [] temp,int index) {
        if(target == 0){
            int product = 1;
            if(index >1){
                for(int i = 0 ; i < index;i++){
                    product*= temp[i];
                }
            }

            res = res < product?product:res;
            return ;
        }
        for(int i = target;i > 0;i--){
            temp[index] = i;
            cutRope(target-i,temp,index+1);
        }
    }
}
