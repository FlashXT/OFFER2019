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
        ListNode dummy = new ListNode(-1);
        dummy.next = pHead;
        ListNode ptr = pHead,ptr2 = pHead,tail = pHead;
        while(ptr!=null){
            ptr2 = ptr;
            while(ptr.val == ptr2.val){
                ptr = ptr.next;
            }

        }
    }
}
