package P04_CodingInterviews.P015_MergeTwoSortedList;

import P04_CodingInterviews.HelpClass.ListNode;
import P04_CodingInterviews.OldVersion.CH2.List;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/7 14:08
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method2 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if(list1 == null || list2 == null)
            return list1 == null ? list2:list1;
        ListNode node;
        if(list1.val < list2.val){
            node = new ListNode(list1.val);
            node.next = Merge(list1.next,list2);
        }

        else{
            node = new ListNode(list2.val);
            node.next = Merge(list1,list2.next);
        }

        return node;
    }
}
