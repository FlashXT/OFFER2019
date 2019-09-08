package P04_CodingInterviews.P016_HasSubtree;

import P04_CodingInterviews.HelpClass.Tree;
import P04_CodingInterviews.HelpClass.TreeNode;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/8,9:44
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
/*
    题目:输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class Main {
    public static void main(String [] args){
        int [] arr1 = {8,8,7,9,2,-1,-1,-1,-1,4,7};
        int [] arr2 = {8,9,2};
        TreeNode root1 = new Tree().BulidTree(arr1);
        TreeNode root2 = new Tree().BulidTree(arr2);
        new Tree().preTraversal(root1);
        System.out.println();
        new Tree().preTraversal(root2);
        boolean res = new Method1().HasSubtree(root1,root2);
        System.out.println(res);


    }
}
