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
        int pushindex = 0;
        for(int i = 0; i < popA.length;i++){
            if(!stack.isEmpty() && stack.peek() == popA[i]){
                stack.pop();

            }else{

                while(stack.isEmpty()|| stack.peek()!=popA[i]){
                    if(pushindex >= pushA.length)return false;
                    stack.push(pushA[pushindex++]);
                }
                stack.pop();
            }

        }
        return stack.isEmpty();
    }
}
