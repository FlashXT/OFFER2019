package P04_CodingInterviews.P055_DeleteDuplication;

import P04_CodingInterviews.HelpClass.ListNode;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/17,22:40
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Main {
    public static  void main(String [] args){
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2); head.next = n1;
        ListNode n2 = new ListNode(2); n1.next = n2;
        ListNode n3 = new ListNode(5); n2.next = n3;
        ListNode n4 = new ListNode(5); n3.next = n4;
        new Method1().deleteDuplication(head);


    }
}
