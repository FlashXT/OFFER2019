package TencentOffer.CH3.Problem17_MergeLinkedList;

import DataStructure.CH2_List.LinkedList;
import DataStructure.CH2_List.Node;

import java.util.Iterator;

public class MergeLinkedList {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 7,7, 9,10};
        Integer[] arr2 = {6, 7, 8, 12,14};
        LinkedList<Integer> list = new LinkedList<>(arr);
        LinkedList<Integer> list2 = new LinkedList<>(arr2);
//        LinkedList<Integer> res = Merge(list, list2);
        LinkedList<Integer> res2 = Merge2(list,list2);
        Iterator<Integer> iter = res2.iterator();
        while (iter.hasNext()) {
            System.out.printf("%d\t", iter.next());
        }
//        Node <Integer> res3 = Merge3(list.head,list2.head);
//        while (res3.next!= null){
//            System.out.printf("%d\t",res3.item);
//            res3 = res3.next;
//        }
        System.out.println();
    }

    //将list1和list2中的结点按顺序复制到新链表中，空间复杂度高
    public static LinkedList<Integer> Merge(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        Node<Integer> ptr1 = list1.head;
        Node<Integer> ptr2 = list2.head;
        LinkedList<Integer> res = new LinkedList<>();
        while (ptr1 != null && ptr2 != null) {
            if (ptr1.item < ptr2.item) {
                res.tailInsert(ptr1.item);
                ptr1 = ptr1.next;
            } else {
                res.tailInsert(ptr2.item);
                ptr2 = ptr2.next;
            }
        }
        while (ptr1 != null) {
            res.tailInsert(ptr1.item);
            ptr1 = ptr1.next;
        }
        while (ptr2 != null) {
            res.tailInsert(ptr2.item);
            ptr2 = ptr2.next;
        }
        return res;
    }

    //将list1和list2中的结点按顺序复制到list1中，返回list1
    public static LinkedList<Integer> Merge2(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        Node<Integer> ptr1 = list1.head;
        Node<Integer> ptr2 = list2.head;

        Node<Integer> ptrres = list1.head;

        while(ptr1 != null && ptr2 != null){
            if(ptr1.item >= ptr2.item){

                ptrres.next = ptr2;
                ptrres = ptr2;
                //ptr2指针后移
                ptr2 = ptr2.next;
                //将ptr2加入到list1中
                ptrres.next = ptr1;
            }
            else{
                ptrres = ptr1;
                ptr1 = ptr1.next;
            }
        }
        if(ptr1 != null){
            ptrres.next = ptr1;
        }
        if(ptr2 != null){
            ptrres.next = ptr2;
        }
        return list1;
    }
    //递归方法
    public static Node Merge3(Node<Integer> phead1,Node<Integer> phead2) {
        if(phead1 == null)
            return phead2;
        else if(phead2 == null)
            return phead1;
        Node<Integer> pHead = null;
        if(phead1.item < phead2.item){
           pHead = phead1;
           pHead.next = Merge3(phead1.next,phead2);
        }
        else{
           pHead = phead2;
           pHead.next = Merge3(phead1,phead2.next);
        }

       return pHead;
    }
}
