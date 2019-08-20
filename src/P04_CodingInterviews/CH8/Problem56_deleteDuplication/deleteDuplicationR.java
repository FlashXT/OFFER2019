package P04_CodingInterviews.CH8.Problem56_deleteDuplication;

public class deleteDuplicationR{

    public static void main(String [] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        ListNode node8 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        Traverse(node1);
        node1 = deleteDuplicationR(node1);
        Traverse(node1);

    }
    public static ListNode deleteDuplicationR(ListNode pHead) {
        if (pHead == null || pHead.next == null) { // 只有0个或1个结点，则返回
            return pHead;
        }
        if (pHead.val == pHead.next.val) { // 当前结点是重复结点
            ListNode pNode = pHead.next;
            while (pNode != null && pNode.val == pHead.val) {
                // 跳过值与当前结点相同的全部结点,找到第一个与当前结点不同的结点
                pNode = pNode.next;
            }
            return deleteDuplicationR(pNode); // 从第一个与当前结点不同的结点开始递归
        } else { // 当前结点不是重复结点
            pHead.next = deleteDuplicationR(pHead.next); // 保留当前结点，从下一个结点开始递归
            return pHead;
        }
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
