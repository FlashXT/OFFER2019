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
        Tree tree1 = new Tree(arr1);
        Tree tree2 = new Tree(arr2);
        tree1.preTraversal();
        System.out.println();
        tree2.preTraversal();
        boolean res = new Method1().HasSubtree(tree1.root,tree2.root);
        System.out.println(res);


    }
}
