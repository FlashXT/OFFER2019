package P04_CodingInterviews.P059_LevelTraversal;

import P04_CodingInterviews.HelpClass.Tree;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/19,17:59
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Main {
    public static void main(String [] args){
        int [] nums = {1,2,3,4,5,6,7,8,9};
        Tree tree = new Tree(nums);
        new Method1().Print(tree.root);
    }
}
