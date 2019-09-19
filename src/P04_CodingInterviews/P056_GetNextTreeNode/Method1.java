package P04_CodingInterviews.P056_GetNextTreeNode;

import P04_CodingInterviews.HelpClass.TreeLinkNode;
import P04_CodingInterviews.HelpClass.TreeNode;

import java.util.Stack;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/19 15:34
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
//二叉树中的L型结构
public class Method1 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode == null) return null;
        TreeLinkNode res = null;
        //如果当前结点的有孩子为空
        if(pNode.right == null){
            TreeLinkNode temp = pNode;
            while(temp.next != null){
                if(temp.next.left == temp){
                    res = temp.next;
                    break;
                }
                temp = temp.next;
            }

        }
        //如果当前结点的右孩子不为空
        else{
            TreeLinkNode temp = pNode.right;
            while(temp.left !=null){
                temp = temp.left;
            }
            res =  temp;
        }
        return res;
    }
}
