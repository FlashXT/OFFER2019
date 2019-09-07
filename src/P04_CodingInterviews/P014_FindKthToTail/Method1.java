package P04_CodingInterviews.P014_FindKthToTail;

import P04_CodingInterviews.HelpClass.ListNode;


/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/7 11:46
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode fast = head,slow = head;
        int i = 1;
        while(i <= k && fast!=null){
            fast = fast.next;
            i++;
        }
        if(i == k+1) {
            while(fast!=null){
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
        return null;
    }
}
