package P04_CodingInterviews.P038_TreeDepth;

import P04_CodingInterviews.HelpClass.TreeNode;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/16,9:57
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public int TreeDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int left = TreeDepth(root.left);
        int right =TreeDepth(root.right);
        return 1+Math.max(left,right);
    }
}
