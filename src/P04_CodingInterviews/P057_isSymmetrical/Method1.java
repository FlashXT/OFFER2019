package P04_CodingInterviews.P057_isSymmetrical;

import P04_CodingInterviews.HelpClass.TreeNode;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/19 16:44
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public boolean isSymmetrical(TreeNode pRoot) {
       if(pRoot == null) return true;
       return isSymmetrical(pRoot.left,pRoot.right);
    }
    private boolean isSymmetrical(TreeNode root1,TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val == root2.val)
            return isSymmetrical(root1.left,root2.right)&&
                    isSymmetrical(root1.right,root2.left);
        else
            return false;
    }
}
