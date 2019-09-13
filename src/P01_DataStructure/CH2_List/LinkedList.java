package P01_DataStructure.CH2_List;

import java.util.Iterator;

public class LinkedList<Item>  implements Iterable<Item>{
    public Node head;
    public int size;
    //创建链表
    public LinkedList(){

    }
    public LinkedList(Item [] item){
        for(Item val :item){
            tailInsert(val);
        }
    }
    //链表尾插插入元素
    public void tailInsert(Item item){
        Node<Item> node = new Node<>(item);
        if(head == null){
            head = node;

        }
        else{
            Node curr = head;
            while(curr.next != null){
                    curr = curr.next;
            }
            curr.next = node;
        }
        size++;

    }
    //链表尾插入结点
    public void tailInsert(Node node){
        if(head == null){
            head = node;

        }
        else{
            Node curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = node;
        }
        size++;

    }
    //链表头插插入元素
    public void headInsert(Item item){
        Node<Item> node = new Node<>(item);
        if(head == null){
            head = node;

        }
        else{
            node.next = head;
            head = node ;
        }
        size++;

    }
    //链表头插插入结点
    public void headInsert(Node node){
        if(head == null){
            head = node;

        }
        else{
            node.next = head;
            head = node ;
        }
        size++;

    }
    //链表删除结点
    public void  delete(Item item){
        Node <Item> ptr = head;
        while(ptr.next != null){
            if(ptr.next.item == item){
                ptr.next = ptr.next.next;
            }
        }

    }
    //链表反转
    public void Reverse(){

        head = ReverseList(head);

    }
    //单链表反转
    public Node ReverseList(Node first){
        if( first.next == null) return first;
        Node head = ReverseList(first.next);
        first.next.next = first;
        first.next= null;
        return head;

    }
    //单链表反转
    public Node ReverseList2(Node head){
        if( head  == null || head.next.next == null) return head;
        Node pNpre = null;
        Node pNode = head;
        Node pNext = null;
        while(pNode != null){
            pNext = pNode.next;
            pNode.next = pNpre;
            pNpre = pNode;
            pNode = pNext;

        }
        return pNpre;
    }




    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    public class ListIterator implements Iterator{

        private Node<Item> curr = head;
        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public Item next() {
            Item item = curr.item;
            curr = curr.next;
            return item;
        }
    }
}
