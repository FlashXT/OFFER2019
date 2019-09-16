package P04_CodingInterviews.P039_IsBalancedTree;

import P04_CodingInterviews.HelpClass.TreeNode;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/16,10:03
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
//递归剪枝
public class Method2 {
    public boolean IsBalanced_Solution(TreeNode root) {
        return TreeDepth(root)!=-1;
    }

    public static int TreeDepth(TreeNode root){
        if(root == null) return 0;
        int left = TreeDepth(root.left);
        if(left == -1) return -1; //剪枝
        int right =TreeDepth(root.right);
        if(right == -1)return -1; //剪枝
        return Math.abs(left-right) >1 ?-1:1+Math.max(left,right);
    }
}
