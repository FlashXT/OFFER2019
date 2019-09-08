package P04_CodingInterviews.P019_GetMininStack;

import java.util.Stack;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/8,11:14
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
        if(stack2.isEmpty()||node < stack2.peek())
            stack2.push(node);
        else
            stack2.push(stack2.peek());
    }

    public void pop() {
        int node = stack1.pop();
        if(node == stack2.peek()){
            while(!stack2.isEmpty()&& stack2.peek()==node)
                stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
