package P04_CodingInterviews.P025_RandomListClone;

import P04_CodingInterviews.HelpClass.RandomListNode;

import java.lang.ref.PhantomReference;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/9,16:06
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null) return pHead;
        CloneNodes(pHead);
        ConnectRandomNode(pHead);
        RandomListNode nhead = ReconnectNodes(pHead);
        return nhead;

    }
    public void CloneNodes(RandomListNode phead){
        RandomListNode pNode = phead;
        while(pNode!=null){
            RandomListNode pCloned = new RandomListNode(pNode.label);
            pCloned.next = pNode.next;
            pNode.next = pCloned;
            pNode = pCloned.next;
        }
    }
    public void ConnectRandomNode(RandomListNode phead){
        RandomListNode pNode = phead;
        while(pNode!= null){
            if(pNode.random != null){
                pNode.next.random = pNode.random.next;
            }
            pNode = pNode.next.next;
        }
    }
    public RandomListNode ReconnectNodes(RandomListNode pHead){
        RandomListNode pNode = pHead;
        RandomListNode newhead = pHead.next;
        RandomListNode ptr = pHead.next;

        while(pNode != null){
            pNode.next = ptr.next;
            pNode = ptr.next;
            if(pNode != null){
                ptr.next = pNode.next;
                ptr = pNode.next;
            }
        }
        return newhead;
    }
}
