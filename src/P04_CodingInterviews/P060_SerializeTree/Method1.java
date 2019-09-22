package P04_CodingInterviews.P060_SerializeTree;

import P04_CodingInterviews.HelpClass.Tree;
import P04_CodingInterviews.HelpClass.TreeNode;

import java.util.Stack;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/19,19:00
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public String Serialize(TreeNode root) {
        if(root == null) return  null;
        StringBuilder res = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while(!stack.isEmpty() || temp!=null){
            if(temp!=null){
                res.append(temp.val+"!");
//                System.out.println(temp.val);
                stack.push(temp);
                temp = temp.left;
            }else{
                res.append("#!");
                temp = stack.pop();
                temp = temp.right;
            }
        }
        res.append("#!");//补全为满二叉树
        System.out.println(res.toString());
        return res.toString();
    }
    public String preTraversal(TreeNode root){
        StringBuilder sb = new StringBuilder();
        if(root == null){
            sb.append("#!");
        }else{
            sb.append(root.val+"!");
            sb.append(preTraversal(root.left));
            sb.append(preTraversal(root.right));
        }
        return sb.toString();
    }
    int index=-1;//类变量
    public TreeNode Deserialize(String str) {
        index++;
        if(str ==null || index >= str.length()) return null;
        String [] nodes = str.split("!");
        if(nodes[index].equals("#")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(nodes[index]));
        root.left = Deserialize(str);
        root.right = Deserialize(str);
        return root;
    }
}
