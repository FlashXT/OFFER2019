package DataStructure.CH2_List;

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
 *
 *      ②链表1和链表2中一个有环： == > 两个链表不相交；
 *
 *      ③链表1和链表2均有环：
 *          a.两个链表各自成环不相交；(6 ,6 结构)
 *          b.两个链表在成环的结点前相交（共享环）;（>--O结构）
 *          c.两个链表在环上相交（共享环）;(=O,两个链表共享换环，但是成环结点不同）
 ***************************************************************************************/
public class LinkListCrossing {
    public static void main(String [] args){
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        int [] arr = {1,2,3,4,5,6,7,8,9,10,11};
        int [] arr2 = {11,21,34,45,58,100};

        for(int item:arr){
            list1.tailInsert(item);
        }
        for(int item:arr2){
            list2.tailInsert(item);
        }
        //testcase1:两个链表均无环，不相交
//        System.out.println(isListCrossing(list1,list2));

        //testcase2:两个链表均无环,相交
//        makeNoLoopCrossing(list1,list2,8,false);
//        System.out.println(isListCrossing(list1,list2));

        //testcase3:两个链表其中一个有环,不相交
//        makeCircle(list1,8);
//        System.out.println(isListCrossing(list1,list2));

        //testcase4:两个链表均有环,不相交（6，6结构）
//        makeCircle(list1,8);
//        makeCircle(list2,34);
//        System.out.println(isListCrossing(list1,list2));

        //testcase5:两个链表均有环,相交（>--O结构）
//        makeNoLoopCrossing(list1,list2,8,true);
//        System.out.println(isListCrossing(list1,list2));

        //testcase6:两个链表均有环,相交（==O结构）
        makeNoLoopCrossing(list1,list2,8,true);
        System.out.println(isListCrossing(list1,list2));

    }
    public static Node  isListCrossing(LinkedList list1,LinkedList list2){

        Node ptr1 = list1.head;
        Node ptr2 = list2.head;
        //两个链表无环的情况
        if(getLoopNode(ptr1) == null && getLoopNode(ptr2) == null){
            return NoLoopListCrossing(list1,list2);
        }
        //两个链表均有环
        else if(getLoopNode(ptr1) != null && getLoopNode(ptr2) != null){
            return TwoLoopListCrossing(list1,list2);
        }

        //两个链表其中一个有环
        else{
            return null;
        }


    }

    //两个无环链表的相交问题
    public static Node NoLoopListCrossing(LinkedList list1,LinkedList list2){
        Node ptr1 = list1.head;
        Node ptr2 = list2.head;
        int size = list1.size - list2.size;
        if(size > 0){
            for(int i = 0; i < size ;i++){
                ptr1 = ptr1.next;
            }
        }
        else{
            for(int i = 0; i < -size ;i++){
                ptr2 = ptr2.next;
            }
        }

        while(ptr1 != null && ptr2 != null){
            if( ptr1 == ptr2)
                return ptr1;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return null;
    }
    //两个有环的链表的相交问题
    public static Node TwoLoopListCrossing(LinkedList list1,LinkedList list2){
        Node loopnode1 = getLoopNode(list1.head);
        Node loopnode2 = getLoopNode(list2.head);
        Node ptr1,ptr2;
        //相当于无环链表的相交问题 （>--O结构）
        if(loopnode1 == loopnode2){
            ptr1 = list1.head;
            ptr2 = list2.head;
            int size = list1.size - list2.size;
            if(size > 0){
                for(int i = 0; i < size ;i++){
                    ptr1 = ptr1.next;
                }
            }
            else{
                for(int i = 0; i < -size ;i++){
                    ptr2 = ptr2.next;
                }
            }

            //仅在此处ptr1的终止条件不同于无环时的判断
            while(ptr1 != loopnode1){
                if( ptr1 == ptr2) return ptr1;
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
            return null;
        }
        else{
            ptr1 = loopnode1.next;
            while(ptr1 != loopnode1){
                if(ptr1 == loopnode2)
                    return ptr1;//（=O结构）
                ptr1 = ptr1.next;
            }
            return null;//(6 ,6 结构)
        }

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

    //测试函数：链表相交(list1 和 list2 在list1 值为 item 的结点处相交)
    public static void makeNoLoopCrossing(LinkedList list1,LinkedList list2, int item,boolean loop){
        //loop 指示list1是否成环
        if (loop)
            makeCircle(list1,item);
        Node ptr1 = list1.head;
        Node ptr2 = list2.head;
        while(ptr2.next != null){
            ptr2 = ptr2.next;
        }
        int i = 0;
        //变换相交点，测试
        while(ptr1 != null && (int)ptr1.item != 9){
            ptr1 = ptr1.next;
            i++;
        }
        ptr2.next = ptr1;
        list2.size += list1.size - i;
    }
}
