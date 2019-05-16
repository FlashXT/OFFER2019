package TencentOffer.CH8.Problem56_deleteDuplication;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/16 17:16;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class deleteDuplication {

    public static void main(String [] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        ListNode node8 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        Traverse(node1);
        node1 = deleteDuplication(node1);
        Traverse(node1);


    }
    public static  ListNode deleteDuplication(ListNode list){
        ListNode ptr0 = list,ptr1 = list,ptr2 = list;
        while(ptr2 != null){
            if(ptr1.val == ptr2.val){
                while(ptr1.val == ptr2.val&&ptr2!=null)
                    ptr2 = ptr2.next;
                ptr0.next = ptr2;
            }

            ptr0 = ptr1;
            ptr1 = ptr2;
            ptr2 = ptr2.next;
        }
        return list;
    }
    public static void Traverse(ListNode list){
        ListNode temp = list;
        while(temp!=null){
            System.out.printf("%d\t",temp.val);
            temp = temp.next;
        }
        System.out.println();
    }
}
