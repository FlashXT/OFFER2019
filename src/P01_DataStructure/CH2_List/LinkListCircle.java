package P01_DataStructure.CH2_List;

import java.util.Iterator;

/***************************************************************************
 *【题目】判断一个链表是否有环;
 *思路1：使用HashSet<Node>,遍历链表，每遍历一个结点，到HashSet中查看是否包含此结点；
 *      不包含则加入HashSet中，若HashSet中已经包含此结点则证明链表有环,且此结点为环
 *      的入口结点；
 *思路2：（双指针穷举遍历），首先从头节点开始，依次遍历单链表的每一个节点。每遍历到一个
 *      新节点，就从头节点重新遍历新节点之前的所有节点，用新节点ID和此节点之前所有节点
 *      ID依次作比较。如果发现新节点之前的所有节点当中存在相同节点ID，则说明该节点被遍
 *      历过两次，链表有环；如果之前的所有节点当中不存在相同的节点，就继续遍历下一个新
 *      节点，继续重复刚才的操作。
 *思路3：(快慢指针的数学方法)首先创建两个指针1和2（在java里就是两个对象引用），同时指向
 *      这个链表的头节点。然后开始一个大循环，在循环体中，让指针1每次向下移动一个节点，
 *      让指针2每次向下移动两个节点，然后比较两个指针指向的节点是否相同。如果相同，则判
 *      断出链表有环，如果不同，则继续下一次循环。
 *      此方法也可以用一个更生动的例子来形容：在一个环形跑道上，两个运动员在同一地点起跑，
 *      一个运动员速度快，一个运动员速度慢。当两人跑了一段时间，速度快的运动员必然会从速
 *      度慢的运动员身后再次追上并超过，原因很简单，因为跑道是环形的。
 *链接：https://blog.csdn.net/u010983881/article/details/78896293
 ***************************************************************************/
public class LinkListCircle {
    public static void main(String [] args){
        LinkedList<Integer> list1 = new LinkedList<>();

        int [] arr = {1,2,3,4,5,6,7,8,9,10,11};
        for(int item:arr){
            list1.tailInsert(item);
        }
        Iterator<Integer> iter = list1.iterator();
        while(iter.hasNext()){
            System.out.printf("%-4d",iter.next());
        }
        makeCircle(list1,7);
        System.out.println();

        System.out.println(getLoopNode(list1).item);



    }

    public static Node getLoopNode(LinkedList list){

        Node ptr1 = list.head; //慢指针，步长为1
        Node ptr2 = list.head; //快指针，步长为2
        while(ptr2 != null && ptr2.next != null){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next.next;
            if(ptr1== ptr2) break;

        }
        if( ptr1 != ptr2) return null;
        ptr2 = list.head;
        while(ptr1!= ptr2){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;

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
