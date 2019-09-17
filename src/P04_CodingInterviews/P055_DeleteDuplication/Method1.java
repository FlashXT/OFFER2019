package P04_CodingInterviews.P055_DeleteDuplication;

import P04_CodingInterviews.HelpClass.ListNode;
import P04_CodingInterviews.OldVersion.CH2.List;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/17,22:41
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public ListNode deleteDuplication(ListNode pHead){
        if(pHead == null) return pHead;
        ListNode dummy = new ListNode(-1);

        ListNode tail = dummy;
        ListNode ptr = pHead,ptr2 = pHead;
        while(ptr!=null){
            ptr2 = ptr;
            ptr = ptr.next;
            while(ptr!=null &&ptr.val == ptr2.val){
                ptr = ptr.next;
            }
            if(ptr2.next == ptr){
                tail.next = ptr2;
                tail = tail.next;
            }

        }
        tail.next=null;
        return dummy.next;
    }
}
