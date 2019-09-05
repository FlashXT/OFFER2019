package P04_CodingInterviews.P003_PrintListFromTailToHead;

import P04_CodingInterviews.HelpClass.ListNode;

import java.util.ArrayList;
import java.util.Arrays;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/5 15:16
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    //递归
    ArrayList<Integer> res = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        PrintList(listNode);
        return res;
    }
    private void PrintList(ListNode listNode){
        if(listNode == null)
            return;
        PrintList(listNode.next);
//        System.out.println(listNode.val);
        res.add(listNode.val);

    }
}
