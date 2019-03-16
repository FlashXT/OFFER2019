package CH2_List;

/**************************************************************************************
 *                      两个单链表相交的一系列问题
 *【题目】在本题中，单链表可能有环，也可能无环。给定两个单链表的头节点head1和head2，这两个链表可
 * 能相交，也可能不相交。请实现一个函数，如果两个链表相交，请返回相交的第一个节点；如果不相交，返
 * 回null即可。
 *
 * 要求：如果链表1的长度为N，链表2的长度为M，时间复杂度请达到O(N+M)，额外空间复杂度请达到O(1)。
 * 思路：分情况讨论：
 *      ①链表1和链表2均无环：
 *          a.两个链表长度相等，从头遍历两个链表，若两个指针在到达结尾前相遇，则相交，否则不相交；
 *          b.两个链表长度不相等，先让指向较长的链表指针先走n步，使两个链表长度相等，然后同a;
 *      ②链表1和链表2中一个有环：
 *          a.两个链表不相交；
 *          b.两个链表在成环的结点前相交（共享环）;
 *          c.两个链表在环上相交（共享环）;
 *      ③链表1和链表2均有环：
 *          a.两个链表不相交；
 *          b.两个链表在成环的结点前相交（共享环）;
 *          c.两个链表在环上相交（共享环）;
 ***************************************************************************************/
public class LinkListCrossing {
    public static void main(String [] args){
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        int [] arr = {1,2,3,4,5,6,7,8,9,10,11};
        for(int item:arr){
            list1.tailInsert(item);
        }
        makeCircle(list1,8);
        System.out.println(getLoopNode(list1.head).item);

    }
    public static void isListCrossing(Node node1,Node node2){

    }
    //快慢指针判有环，同步查找成环点
    public static Node getLoopNode(Node node){
        if(node == null && node.next == null) return null;
        Node node1 = node;//慢指针，步长为1
        Node node2 = node;//快指针，步长为2
        while(node2 != null && node2.next!=null){
            node1 = node1.next;
            node2 = node2.next.next;
            if(node1 == node2) break;
        }
        if(node1 != node2 ) return null;
        //有环则返回成环的结点
        node1 = node;
        while(node1 != node2){
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }


    public static void makeCircle(LinkedList list,int key){
        Node ptr1 = list.head;
        while((int)ptr1.item != key){
            ptr1 = ptr1.next;
        }
        Node ptr2 = list.head;
        while(ptr2.next !=null){
            ptr2 = ptr2.next;
        }
        ptr2.next = ptr1;
    }
}
