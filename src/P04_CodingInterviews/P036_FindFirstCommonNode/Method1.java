package P04_CodingInterviews.P036_FindFirstCommonNode;

import P04_CodingInterviews.HelpClass.ListNode;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/15,18:26
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
//复杂度O(m+n)
public class Method1 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode ptr1 = pHead1,ptr2 = pHead2;
        while(ptr1!=ptr2){
            if(ptr1==null)
                ptr1 = pHead2;
            else
                ptr1 = ptr1.next;
            if(ptr2 == null)
                ptr2 = pHead1;
            else
                ptr2 = ptr2.next;
        }
        return ptr1;
    }
}
