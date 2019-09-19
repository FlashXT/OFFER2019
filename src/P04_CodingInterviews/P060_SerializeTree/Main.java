package P04_CodingInterviews.P060_SerializeTree;

import P04_CodingInterviews.HelpClass.Tree;
import P04_CodingInterviews.HelpClass.TreeNode;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/19,19:00
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Main {
    public static  void main(String [] args){
        int [] nums = {};
        Tree tree = new Tree(nums);
        String res= new Method1().Serialize(tree.root);
        TreeNode root = new Method1().Deserialize(res);
        System.out.println();
    }
}
