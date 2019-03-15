package List;

import java.util.Iterator;

//链表的结点类型
class Node<Item>{
    Item item;
    Node next;
    public Node(){}
    public Node(Item item){
        this.item = item;
        this.next = null;
    }

}
public class LinkedList<Item>  implements Iterable<Item>{
    public Node head;
    public int size;
    //创建链表
    public LinkedList(){

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
    //链表尾插插入结点
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
        if(first == null || first.next == null) return first;
        Node head = ReverseList(first.next);
        first.next.next = first;
        first.next= null;
        return head;

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
