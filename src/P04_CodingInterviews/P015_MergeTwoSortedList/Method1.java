package P04_CodingInterviews.P015_MergeTwoSortedList;

import P04_CodingInterviews.HelpClass.ListNode;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/7 14:08
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if(list1 ==null || list2 == null)
            return list1 == null ? list2:list1;
        ListNode ptr1 = list1,ptr2 = list2;
        ListNode dummy = new ListNode(-1),ptrres = dummy;
        while(ptr1!=null && ptr2 !=null){
            if(ptr1.val < ptr2.val){
                ptrres.next = ptr1;
                ptrres = ptrres.next;
                ptr1 = ptr1.next;
            }else{
                ptrres.next = ptr2;
                ptrres = ptrres.next;
                ptr2 = ptr2.next;
            }
        }
        if(ptr1 == null)
            ptrres.next = ptr2;
        if(ptr2 == null)
            ptrres.next = ptr1;
        return dummy.next;
    }
}
