package P04_CodingInterviews.P014_FindKthToTail;

import P04_CodingInterviews.HelpClass.ListNode;

import java.util.MissingResourceException;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/7 11:46
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Main {
    public static  void main(String [] args){
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2); head.next = n1;
        ListNode n2 = new ListNode(3); n1.next = n2;
        ListNode n3 = new ListNode(4); n2.next = n3;
        ListNode n4 = new ListNode(5); n3.next = n4;
        ListNode res = new Method1().FindKthToTail(head,5);


    }
}
