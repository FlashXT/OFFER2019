package P04_CodingInterviews.P017_MirrorTree;

import P04_CodingInterviews.HelpClass.TreeNode;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/8,10:22
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public void Mirror(TreeNode root) {
        if(root == null) return ;
        MirrorTree(root);
    }
    public TreeNode MirrorTree(TreeNode root) {
        if(root == null) return null;
        TreeNode temp = MirrorTree(root.left);
        root.left = MirrorTree(root.right);
        root.right =temp;
        return root;
    }
}
