package TencentOffer.CH4.AbstractConcrete;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/10 9:56;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/

/*************************************************************************
 * 题目描述:
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊
 * 指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返
 * 回参数中的节点引用，否则判题程序会直接返回空）
 *************************************************************************/
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class Problem26_LinkedListCopy {
    public static void main(String [] args){
        RandomListNode pHead = new RandomListNode(0);
//        RandomListNode pNode1 = new RandomListNode(1);
//        RandomListNode pNode2 = new RandomListNode(2);
//        RandomListNode pNode3 = new RandomListNode(3);
//        RandomListNode pNode4 = new RandomListNode(4);
//        pHead.next = pNode1;pHead.random = pNode3;
//        pNode1.next = pNode2;pNode1.random = pNode4;
//        pNode2.next = pNode3;
//        pNode3.next = pNode4;pNode3.random = pNode2;
        RandomListNode node = Clone(pHead);
        System.out.println(node);
    }
    public static RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null) return pHead;
        CloneNodes(pHead);
        ConnectRandomNode(pHead);
        RandomListNode head = ReconnectNodes(pHead);
        return head;

    }
    public static void CloneNodes(RandomListNode pHead){

        RandomListNode pNode = pHead;
        while(pNode != null){
            RandomListNode pCloned = new RandomListNode(pNode.label);
            pCloned.next = pNode.next;
            pNode.next = pCloned;
            pNode = pCloned.next;
        }

    }
    public static void ConnectRandomNode(RandomListNode pHead){
        RandomListNode pNode = pHead;
        while(pNode != null){
            if(pNode.random!=null){
                pNode.next.random = pNode.random.next;
            }
            pNode = pNode.next.next;
        }

    }
    public static RandomListNode ReconnectNodes(RandomListNode pHead){
        RandomListNode pNode = pHead;
        RandomListNode newHead = pHead.next;
        RandomListNode pNode2 = pHead.next;
        while(pNode!= null){
            pNode.next = pNode2.next;
            pNode = pNode2.next;
            if(pNode !=null){
                pNode2.next = pNode.next;
                pNode2 = pNode.next;
            }

        }
        return newHead;

    }
}
