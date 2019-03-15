package List;

import Stack_Queue.ArrayStack;

import java.util.Iterator;

/****************************************************************
 * 判断一个链表是否为回文结构;
 *【题目】给定一个链表的头节点head，请判断该链表是否为回文结构。
 *例如：
 *      1->2->1，返回true。
 *      1->2->2->1，返回true。
 *      15->6->15，返回true。
 *      1->2->3，返回false。
 *基本解法： 使用栈结构，用两个指针，指针步长为1，指针2步长为2；当指针2走
 *     到链表最后一个结点时，指针1走到链表中间的结点，然后从指针1的位置开
 *     始，将后续的结点压入一个栈中，然后从头遍历原链表，指针走一步，栈中
 *     弹出一个元素，若相等继续遍历和出栈，直到栈为空，返回true;否则，返
 *     回false;
 *进阶方法：用两个指针，指针步长为1，指针2步长为2；当指针2走到链表最后一个
 *     结点时，指针1走到链表中间的结点，然后从指针1开始将链表的后半部分反
 *     转，然后遍历前半部分和后半部分，判断是否为回文串,然后将链表还原；
 *
 *进阶：如果链表长度为N，时间复杂度达到O(N)，额外空间复杂度达到O(1)。
 *****************************************************************/


public class ListPalindrome {
    public static void main(String [] args) {
        int[] arr = {1, 2, 3,5,3, 2, 1};
        LinkedList<Integer> list = new LinkedList<>();
        for (int item : arr) {
            list.tailInsert(item);
        }
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            System.out.printf("%-2d", iter.next());
        }
        System.out.println();
        System.out.println(isPalindromePro(list));
        Iterator iter2 = list.iterator();
        while (iter2.hasNext()) {
            System.out.printf("%-2d", iter2.next());
        }

    }
    public static boolean isPalindrome(LinkedList<Integer> list){

        //定义两个指针，指针1步长为1，指针2步长为2
        Node<Integer> ptr1 = list.head;
        Node<Integer> ptr2 = list.head;
        //定义Stack
        ArrayStack<Integer> stack = new ArrayStack<>(list.size);
        while(ptr2!=null && ptr2.next!= null){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next.next;
        }

        while(ptr1 != null){
            stack.push(ptr1.item);
            ptr1 = ptr1.next;
        }
        ptr1 = list.head;
        while (!stack.isEmpty()){
            if( ptr1.item != stack.pop())
                return false;
            ptr1 = ptr1.next;
        }
        return true;

    }

    //进阶方法
    public static boolean isPalindromePro(LinkedList<Integer> list){

        //如果链表的元素为偶数个，在中点位置任意添加一个元素，变为奇数个元素；
        if(list.size %2 ==0){
            int len = list.size/2;
            Node ptr = list.head;
            for(int i=1;i<len;i++){
                ptr = ptr.next;
            }
            Node temp = new Node(0);
            temp.next = ptr.next;
            ptr.next = temp;
        }

        //定义两个指针，指针1步长为1，指针2步长为2
        Node<Integer> ptr1 = list.head;
        Node<Integer> ptr2 = list.head;

        while(ptr2!= null && ptr2.next!=null){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next.next;
        }
        //反转list的后半部分
        Node<Integer> ptr3 = ptr1;
        Node<Integer> ptr4 = ptr3.next;
        Node<Integer> temp;
        ptr3.next = null;
        while(ptr3 != ptr2){
            temp = ptr4.next;
            ptr4.next = ptr3;
            ptr3 = ptr4;
            ptr4 = temp;
        }
        ptr4 = list.head;
        boolean flag = false;
        while (ptr3!= ptr4){
            if( ptr3.item != ptr4.item)
                break;
            ptr3 = ptr3.next;
            ptr4 = ptr4.next;
        }
        if(ptr3== ptr4)
            flag = true;

        //链表还原
        ptr3 = ptr2;
        ptr4 = ptr3.next;
        ptr3.next = null;
        while(ptr3 != ptr1){
            temp = ptr4.next;
            ptr4.next = ptr3;
            ptr3 = ptr4;
            ptr4 = temp;
        }

        if(list.size %2 ==0){
            int len = list.size/2;
            Node ptr = list.head;
            for(int i=1;i<len;i++){
                ptr = ptr.next;
            }
            ptr.next = ptr.next.next;
        }
        return flag;
    }

}
