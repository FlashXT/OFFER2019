package P01_DataStructure.CH2_List;

//链表的结点类型
public class Node<Item>{
    public Item item;
    public Node next;
    public Node(){}
    public Node(Item item){
        this.item = item;
        this.next = null;
    }

}
