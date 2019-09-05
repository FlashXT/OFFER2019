package P04_CodingInterviews.P003_PrintListFromTailToHead;

import P04_CodingInterviews.HelpClass.ListNode;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/5 15:16
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
/*
    题目:输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class Main {
    public static void main(String [] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;node2.next=node3;node3.next=node4;
        new Method1().printListFromTailToHead(node1);
    }
}
