package P04_CodingInterviews;

import P04_CodingInterviews.HelpClass.Tree;
import P04_CodingInterviews.HelpClass.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/11 12:22
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
//二叉树的右视图
public class Main1 {
    public static void main(String [] args){
        int [] nums = {1,2,3,4,-1,-1,-1,5,6};
        TreeNode root = new Tree().BulidTree(nums);
        LevelTraversal(root);
    }
    public static void LevelTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode last = root;
        TreeNode temp = root;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
           // System.out.print(node.val);
            if(node.left!=null){
                queue.offer(node.left);
                last = node.left;
            }
            if(node.right!=null){
                queue.offer(node.right);
                last = node.right;
            }
            if(node == temp){
                System.out.println(node.val);
                temp = last;

            }
        }

    }
}
