package P04_CodingInterviews.P026_BST2LinkedList;

import P04_CodingInterviews.HelpClass.TreeNode;

import java.util.Stack;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/9,16:56
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = pRootOfTree;
        TreeNode head = null,ptr = head;
        while(!stack.isEmpty() ||temp!=null){
            if(temp!=null){
                stack.push(temp);
                temp = temp.left;
            }else{
                temp = stack.pop();
                if(head == null){
                    head = temp;
                    ptr = head;
                }else{
                    ptr.right = temp;
                    temp.left = ptr;
                    ptr = temp;
                }
                System.out.print(temp.val+"\t");
                temp = temp.right;
            }
        }
        return head;
    }
    public TreeNode ConvertR(TreeNode root) {
        if(root == null) return root;
        if(root.left == null && root.right == null) return root;
        //①转换左子树，返回链表头结点
        TreeNode left = ConvertR(root.left);
        //②找到左子树的最后一个结点
        TreeNode temp = left;
        while(temp != null && temp.right!=null){
            temp = temp.right;
        }
        //③如果左子树链表不为空，将根结点追加到左子树链表
        if(left!=null){
            temp.right = root;
            root.left = temp;
        }
        //④转换右子树，返回链表头结点
        TreeNode right = ConvertR(root.right);
        //⑤如果右子树链表不为空的话，将该链表追加到root节点之后
        if(right != null){
            right.left = root;
            root.right = right;
        }
        return left == null?root:left;
    }
}
