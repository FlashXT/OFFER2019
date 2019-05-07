package TencentOffer.CH3;


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
public class Problem16_ReverseLinkedlist {
    public static void main(String [] args){

        Node head = null ;//= new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        Node rhead = ReverseList2(head);
        System.out.println("AA");
    }

    //单链表反转
    public static Node ReverseList(Node head){
        if( head  == null || head.next == null) return head;
        Node preNode = null;
        Node pNode = head;
        Node revhead = null;
        while(pNode != null){
            Node pNext = pNode.next;
            if(pNext == null)
                revhead = pNode;
            pNode.next = preNode;
            preNode = pNode;
            pNode = pNext;
        }
        return revhead;
    }

    //单链表反转
    public static Node ReverseList2(Node head){
        if( head == null ||head.next  == null)
            return head;
        Node rhead = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return rhead;
    }
}
