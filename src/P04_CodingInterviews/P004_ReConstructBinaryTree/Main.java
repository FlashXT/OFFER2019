package P04_CodingInterviews.P004_ReConstructBinaryTree;

import P04_CodingInterviews.HelpClass.TreeNode;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/5 15:33
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
/*
    题目:输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序
        遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序
        列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Main {
    public static void main(String [] args){
        int [] pre = {1,2,4,7,3,5,6,8};
        int [] in = {4,7,2,1,5,3,8,6};
        TreeNode root = new Method1().reConstructBinaryTree(pre,in);
        preTraverseal(root);
        System.out.println();
        inTraverseal(root);
    }
    public static void preTraverseal(TreeNode root){
        if(root == null) return;
        System.out.print(root.val+" ");
        preTraverseal(root.left);
        preTraverseal(root.right);

    }
    public static void inTraverseal(TreeNode root){
        if(root == null) return;

        inTraverseal(root.left);
        System.out.print(root.val+" ");
        inTraverseal(root.right);

    }
}
