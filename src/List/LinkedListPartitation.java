package List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**********************************************************************************
 *【题目】将单向链表按某值划分成左边小、中间相等、右边大的形式给定一个单向链表的头节点head，
 * 节点的值类型是整型，再给定一个整数pivot。实现一个调整链表的函数，将链表调整为左部分都是
 * 值小于pivot的节点，中间部分都是值等于pivot的节点，右部分都是值大于pivot的节点。除这个
 * 要求外，对调整后的节点顺序没有更多的要求。
 *
 * 例如：链表9->0->4->5->1，pivot=3。
 *调整后链表可以是1->0->4->9->5，也可以是0->1->9->5->4。总之，满足左部分都是小于3的节点，
 *中间部分都是等于3的节点（本例中这个部分为空），右部分都是大于3的节点即可。对某部分内部的节
 *点顺序不做要求。
 *
 * 思路1：遍历链表，取出链表的所有元素，进行排序，然后放回原链表；这种方法事件复杂度和空间复
 *       杂度都很高；
 * 思路2：准备三个链表，一个放小于pivot的结点，一个放等于pivot的结点，另一个放大于pivot的
 *       结点;然后再把这三个链表和为一个链表；
 * 思路3：准备一个新链表，遍历链表，小于pivot的采用头插法插入新链表，大于pivot的采用尾插法
 *       插入新链表，对于链表中含有pivot结点，可以在创建新链表时，插入一个pivot结点，并保
 *       存指向pivot的指针，待遍历完原链表，在根据情况删除该结点；
 **********************************************************************************/
public class LinkedListPartitation {
    public static void main(String [] args){
        int [] arr = {6,7,2,3,4,10,10,12,34,32};
        int pivot = 10;
        LinkedList <Integer> list = new LinkedList<>();
        for(int item:arr){
            list.tailInsert(item);
        }

        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            System.out.printf("%d\t", iter.next());
        }
//        Partitation(list);
//        System.out.println();
//        Iterator iter2 = list.iterator();
//        while (iter2.hasNext()) {
//            System.out.printf("%d\t", iter2.next());
//        }

//        LinkedList test =  Partitation2(list,pivot);
//        System.out.println();
//        Iterator iter2 = test.iterator();
//        while (iter2.hasNext()) {
//            System.out.printf("%d\t", iter2.next());
//        }
        LinkedList test =  PartitationPro(list,pivot);
        System.out.println();
        Iterator iter2 = test.iterator();
        while (iter2.hasNext()) {
            System.out.printf("%d\t", iter2.next());
        }


    }

    public static LinkedList PartitationPro(LinkedList <Integer> list,int pivot){
        LinkedList<Integer> linklist = new LinkedList<>();
        Node nodep = new Node(pivot);
        Node node ;
        linklist.headInsert(nodep);
        Node ptr = list.head;
        while(ptr != null){
            if((int)ptr.item < pivot){
                linklist.headInsert((int)ptr.item);
            }
            else if((int)ptr.item == pivot){
                node = new Node((int)ptr.item);
                node.next = nodep.next;
                nodep.next=node;
            }

            else{
                linklist.tailInsert((int)ptr.item);
            }
            ptr = ptr.next;
        }
        ptr =linklist.head;
        if(ptr == nodep) linklist.head= linklist.head.next ;
        else{
            while( ptr.next!= nodep){
                ptr = ptr.next;
            }
            ptr.next = ptr.next.next;
        }
        return  linklist;
    }

    public static LinkedList Partitation2(LinkedList <Integer> list,int pivot){
        LinkedList<Integer> lessthan = new LinkedList<>();
        LinkedList<Integer> equal = new LinkedList<>();
        LinkedList<Integer> bigthan = new LinkedList<>();
        Node ptr = list.head;
        Node lptr = list.head;
        Node eptr = list.head;


        while(ptr != null){
            if((int)ptr.item < pivot){
                lptr = new Node(ptr.item);
                lessthan.tailInsert(lptr);
            }
            else if((int)ptr.item == pivot){
                eptr = new Node(ptr.item);
                equal.tailInsert(eptr);
            }

            else{
                bigthan.tailInsert((int)ptr.item);
            }
            ptr = ptr.next;
        }
        // lessthan,equal,bigthan均不空
        if(lessthan.size !=0 &&equal.size !=0 && bigthan.size!=0){
            lptr.next = equal.head;
            eptr.next = bigthan.head;
        }
        // lessthan不空,equal不空,bigthan空
        else if(lessthan.size !=0 &&equal.size !=0 && bigthan.size!=0){
            lptr.next = equal.head;
        }
        // lessthan空,equal不空,bigthan不空
        else if(lessthan.size ==0 &&equal.size !=0 && bigthan.size!=0){
            lessthan.head = equal.head;
            eptr.next = bigthan.head;
        }
        // lessthan不空,equal空,bigthan不空
        else if(lessthan.size !=0 &&equal.size ==0 && bigthan.size!=0){
            lptr.next =  bigthan.head;
        }

        // lessthan空,equal不空,bigthan空
        else if(lessthan.size ==0 &&equal.size !=0 && bigthan.size==0){
            lessthan.head = equal.head;
        }
        // lessthan空,equal空,bigthan不空
        else if(lessthan.size ==0 &&equal.size ==0 && bigthan.size!=0){
            lessthan.head = bigthan.head;
        }

        return lessthan;

    }

    public static void Partitation(LinkedList <Integer> list){
        int [] arr = new int[list.size];
        Node ptr = list.head;
        int i = 0;
        while(ptr!=null){
            arr[i++] =(int)ptr.item;
            ptr = ptr.next;
        }
        InsertSort(arr);
        ptr = list.head;
        for(int item:arr){
            ptr.item = item;
            ptr = ptr.next;
        }

    }
    public static void InsertSort(int[] arr){
       int temp;
        for(int i = 1; i < arr.length;i++){
            if(arr[i-1]> arr[i]){
                for(int j = i; j > 0;j--){
                    if(arr[j-1] > arr[j]){
                        temp = arr[j-1];
                        arr[j-1] = arr[j];
                        arr[j] = temp;
                    }
                }
            }

        }

    }
}
