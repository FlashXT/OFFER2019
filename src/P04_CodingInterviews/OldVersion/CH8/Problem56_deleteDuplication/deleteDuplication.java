package P04_CodingInterviews.OldVersion.CH8.Problem56_deleteDuplication;

public class deleteDuplication {

    public static void main(String [] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
//        ListNode node8 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
//        node7.next = node8;
        Traverse(node1);
        node1 = deleteDuplication(node1);
        Traverse(node1);


    }
    public static  ListNode deleteDuplication(ListNode list){
        ListNode ptr0 = new ListNode(Integer.MIN_VALUE);
        ptr0.next = list;
        ListNode ptr1 = list,ptr2 = list.next;
        while(ptr2 != null){
            if(ptr1.val == ptr2.val){
                while(ptr2!=null&&ptr1.val == ptr2.val)
                    ptr2 = ptr2.next;
                ptr0.next = ptr2;
                if(ptr0.val == Integer.MIN_VALUE)
                    list = ptr2;
            }
            else{
                ptr0 = ptr1;
            }
            if(ptr1!= null && ptr2!=null){
                ptr1 = ptr2;
                ptr2 = ptr2.next;
            }
        }
        if(ptr0.val == Integer.MIN_VALUE)
            list = ptr0.next;

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
