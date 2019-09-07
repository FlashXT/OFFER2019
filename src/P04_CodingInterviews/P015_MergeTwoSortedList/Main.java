package P04_CodingInterviews.P015_MergeTwoSortedList;

import P04_CodingInterviews.HelpClass.ListNode;
import P04_CodingInterviews.OldVersion.CH2.List;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/7 14:08
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Main {
    public static void main(String [] args){
        ListNode head1 = new ListNode(1);
        ListNode h1n1 = new ListNode(3);head1.next = h1n1;
        ListNode h1n2 = new ListNode(5);h1n1.next = h1n2;
        ListNode h1n3 = new ListNode(7);h1n2.next = h1n3;

        ListNode head2 = new ListNode(2);
        ListNode h2n1 = new ListNode(4);head2.next = h2n1;
        ListNode h2n2 = new ListNode(6);h2n1.next = h2n2;
        ListNode h2n3 = new ListNode(8);h2n2.next = h2n3;
        new Method1().Merge(head1,head2);

    }
}
