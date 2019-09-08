package P04_CodingInterviews.P016_HasSubtree;

import P04_CodingInterviews.HelpClass.TreeNode;

import java.util.HashMap;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/8,9:45
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(root2 == null)
            return false;
        boolean res = false;
        if( root1 != null){
            if(root1.val == root2.val)
                res = isSubTree(root1,root2);
            if(!res)
                res = HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);

        }
        return res;
    }
    //类似于判断两棵树是否相同,但是递归退出条件不同
    public boolean isSubTree(TreeNode root1, TreeNode root2){
        //如果root2已经遍历完了都能对应的上，返回true
        if(root2 == null) return true;
        //如果root2还没有遍历完，root1却遍历完了.返回false
        if(root1 == null) return false;
        if(root1.val == root2.val)
            return isSubTree(root1.left,root2.left)&&isSubTree(root1.right,root2.right);
        return false;
    }
}
