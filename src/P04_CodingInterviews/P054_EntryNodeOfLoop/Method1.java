package P04_CodingInterviews.P054_EntryNodeOfLoop;

import P04_CodingInterviews.HelpClass.ListNode;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/17,22:31
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead == null || pHead.next==null) return null;
        ListNode fast = pHead,slow = pHead;
        while(slow!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        if( slow != fast) return null;
        slow = pHead;
        while(slow!= fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
