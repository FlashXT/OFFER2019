package P04_CodingInterviews.P003_PrintListFromTailToHead;

import P04_CodingInterviews.HelpClass.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/5 15:16
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method2 {
    //利用栈先进后出的特点

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        ListNode ptr = listNode;
        while(ptr!=null){
            stack.push(ptr.val);
            ptr = ptr.next;
        }
        while(!stack.isEmpty())
            res.add(stack.pop());
        return res;
    }

}
