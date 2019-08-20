package P04_CodingInterviews.CH4.AbstractConcrete;

import java.util.Stack;
/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/10 11:20;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/

/******************************************************************
 * 题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新
 * 的结点，只能调整树中结点指针的指向。
 *******************************************************************/
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class Problem27_Tree2DList {
    public static void main(String [] args){
        int [] arr= {10,6,14,4,8,12,16};
        TreeNode root = bulidTree(arr,0);
        root = ConvertR(root);
        System.out.println();

    }
    //中序遍历过程中修改指针
    public static TreeNode Convert(TreeNode root) {
        if(root == null) return null;
        TreeNode temp = root;
        TreeNode head = null;
        TreeNode ptr = head;
        TreeNode pretemp = root;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || temp!= null){
            if(temp!= null){
                stack.push(temp);
                temp = temp.left;
            }
            else{
                temp = stack.pop();
                if(ptr == null){
                    head = temp;
                    ptr = head;
                }
                else{
                    ptr.right = temp;
                    temp.left = ptr;
                    ptr= temp;
                }
                temp = temp.right;
            }
        }
        System.out.println();
        return head;
    }

    public static TreeNode ConvertR(TreeNode root) {
        if(root==null)
            return null;
        if(root.left==null&&root.right==null)
            return root;
        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = Convert(root.left);
        TreeNode p = left;
        // 2.定位至左子树双链表最后一个节点
        while(p!=null&&p.right!=null){
            p = p.right;
        }
        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if(left!=null){
            p.right = root;
            root.left = p;
        }
        // 4.将右子树构造成双链表，并返回链表头节点
        TreeNode right = Convert(root.right);
        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
        if(right!=null){
            right.left = root;
            root.right = right;
        }
        return left!=null?left:root;
    }

    public static TreeNode bulidTree(int[] arr,int index){
        if(index >= arr.length || arr[index] ==-1)
            return null;
        TreeNode root = new TreeNode(arr[index]);
        root.left = bulidTree(arr,2*index+1);
        root.right = bulidTree(arr,2*index+2);
        return root;

    }
}
