package P04_CodingInterviews.P036_FindFirstCommonNode;

import P04_CodingInterviews.HelpClass.ListNode;
import P04_CodingInterviews.OldVersion.CH2.List;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/15,18:26
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method2 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = getlen(pHead1);
        int len2 = getlen(pHead2);
        if(len1 < len2){
            ListNode temp = pHead1;
            pHead1 = pHead2;
            pHead2 = temp;
            int len = len1;
            len1 = len2;
            len2 = len;
        }
        ListNode ptr1 = pHead1;
        int l = len1-len2;
        while(l >0){
            ptr1 = ptr1.next;
            l--;
        }
        ListNode ptr2 = pHead2;
        while(ptr1!=ptr2){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }
    public static int getlen(ListNode head){
        if(head==null ) return 0;
        ListNode ptr = head;
        int len = 0;
        while(ptr!=null){
            ptr = ptr.next;
            len++;
        }
        return len;
    }
}
