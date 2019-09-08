package P04_CodingInterviews.P022_LevelOrderTraversal;

import P04_CodingInterviews.HelpClass.Tree;
import P04_CodingInterviews.HelpClass.TreeNode;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/8 21:08
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Main {
    public static void main(String [] args){
        int [] nums = {10,6,14,4,8,12,16};
        TreeNode root = new Tree().BulidTree(nums);
        new Method1().PrintFromTopToBottom(root);
    }
}
