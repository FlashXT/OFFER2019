package P04_CodingInterviews.P036_FindFirstCommonNode;

import P04_CodingInterviews.HelpClass.ListNode;


/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/15,18:25
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Main {
    public static void main(String [] args){
        ListNode head1 = new ListNode(-1);

        ListNode node11 = new ListNode(0);head1.next = node11;
        ListNode node12 = new ListNode(2);node11.next = node12;

        ListNode head2 = new ListNode(-2);
        ListNode node21 = new ListNode(1);head2.next = node21;

        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node12.next = node3;node21.next = node3;
        node3.next = node4;
        new Method2().FindFirstCommonNode(head1,head2);


    }
}
