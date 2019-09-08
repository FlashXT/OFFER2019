package P04_CodingInterviews.P020_IsPopOrder;

import java.util.Stack;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/8,11:23
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length == 0 && popA.length == 0) return true;
        if(pushA.length != popA.length) return false;
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for(int i = 0; i < popA.length;i++){
            if(!stack.isEmpty() && popA[i] == stack.peek())
                stack.pop();
            else{
                while( j < pushA.length){
                    if(pushA[j] == popA[i]){
                        break;
                    }
                    stack.push(pushA[j]);
                    j++;
                }
                if(j == pushA.length)
                    return false;
                j++;
            }
        }
        return true;
    }
}
