package P04_CodingInterviews.P061_KthNode;

import P04_CodingInterviews.HelpClass.Tree;
import P04_CodingInterviews.HelpClass.TreeNode;

import java.util.Stack;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/19,20:31
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public TreeNode KthNode(TreeNode pRoot, int k)    {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = pRoot;
        while(!stack.isEmpty() || temp!=null){
            if(temp!=null){
                stack.push(temp);
                temp = temp.left;
            }else{
                temp = stack.pop();
                k--;
                if(k==0) return temp;
                temp = temp.right;
            }
        }
        return null;
    }
}
