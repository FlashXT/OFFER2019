package P04_CodingInterviews.P021_ReverseList;

import P04_CodingInterviews.HelpClass.ListNode;
import P04_CodingInterviews.OldVersion.CH2.List;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/8,17:02
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method2 {

    public ListNode ReverseList(ListNode head) {
        if( head == null || head.next == null ) return head;
        ListNode ptr = null,pnode = head,pnext =null;
        while(pnode !=null){
            pnext = pnode.next;
            pnode.next = ptr;
            ptr = pnode;
            pnode = pnext;
        }
        return ptr;
    }
}
