package DataStructure.CH2_List;

/*****************************************************************************
 * 双向链表的实现：
 * 双线链表定义：
 * ① 每一个结点包含两个指针，一个指向前驱，一个指向后继结点；
 * ②双向链表为空时，第一个系结点的两个指针均指向自己；
 * ③双向链表不为空时，第一个结点的前驱指针指向最后一个结点；
 *   最后一个结点的后继指针指向的第一个结点；
 *
 */

class DNode<Item>{
    Item item;
    DNode prior;
    DNode next;
    public DNode(){  }
    public DNode(Item item){
        this.item = item;
        this.prior = this;
        this.next = this;
    }
}
public class DulinkList<Item> {


    public DNode <Item> head;
    int size;
    public DulinkList(){
        head = null;
        size = 0;
    }

    //头部插入结点
    public void headInsert(DNode node){

        if(head == null){
            head  = node;
        }
        else{
            node.next = head;
            node.prior = head.prior;
            node.next.prior = node;
            node.prior.next =node;
            head = node;
        }
        this.size++;
    }

    //尾部插入结点
    public void tailInsert(DNode node){

        if(head == null){
            head  = node;
        }
        else{
            head.prior.next = node;
            node.prior =  head.prior;
            node.next  = head;
            head.prior = node;
        }
        this.size++;
    }
    //删除指定位位置的结点
    public DNode deleteNode(int pos){
        DNode ptr = head;
        for(int i = 1 ; i < pos-1;i++){
            ptr = ptr.next;
        }
        DNode res = ptr.next;
        ptr.next = res.next;
        res.next.prior = ptr;
        return res;


    }
    //反转双向链表
    public void DulinklistReverse(){
        DNode ptr1 = head;
        DNode temp1,temp2 ;
        while(ptr1.next != head){
            temp1 = ptr1.next;
            temp2 = ptr1.prior;
            ptr1.next = temp2;
            ptr1.prior = temp1;
            ptr1 = temp1;
        }
        //处理原链表的最后一个结点
        temp1 = ptr1.next;
        temp2 = ptr1.prior;
        ptr1.prior = temp1;
        ptr1.next = temp2;
        //处理新链表的最后一个结点（原链表的第一个结点）
        temp1.next = ptr1;
        //新的头指针
        head = ptr1;

    }

    //顺序打印双向链表
    public  void Print(){
        DNode ptr = head;
        while (ptr.next != head) {
            System.out.printf("%-4d",ptr.item);
            ptr = ptr.next;
        }
        System.out.printf("%-4d\n",ptr.item);
    }
    //逆序打印双向链表
    public  void Print2(){
        DNode ptr = head.prior;
        while (ptr.prior != head.prior) {
            System.out.printf("%-4d",ptr.item);
            ptr = ptr.prior;
        }
        System.out.printf("%-4d\n",ptr.item);
    }

}
