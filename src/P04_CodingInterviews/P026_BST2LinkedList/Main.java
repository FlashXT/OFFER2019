package P04_CodingInterviews.P026_BST2LinkedList;

import P04_CodingInterviews.HelpClass.Tree;
import P04_CodingInterviews.HelpClass.TreeNode;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/9,16:56
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Main {
    public static void main(String [] args){
        int [] nums = {1,2,3,4,5,6,7};
        TreeNode root = new Tree().BulidTree(nums);
        TreeNode head = new Method1().Convert(root);
        System.out.print(head.val);
    }
}
