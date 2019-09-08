package P04_CodingInterviews.P021_ReverseList;

import P04_CodingInterviews.HelpClass.ListNode;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/8,17:02
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public ListNode ReverseList(ListNode head) {
        if( head == null || head.next == null ) return head;
        ListNode nhead = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return nhead;
    }
}
