package TencentOffer.CH3.Problem18_Tree;

import java.util.Stack;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/7 17:04;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class SymmetricBinaryTree {

    public static void main(String [] args){
        int [] arr = {1,2,3,4,5,6,7,8};
        TreeNode tree = BulidTree(arr,0);
        preTraverse(tree);
        System.out.println();
        midTraverse(tree);
    }

    public static TreeNode TreeMirrorImage2(TreeNode root){
        TreeNode temp = root;
        Stack<TreeNode> stack = new Stack<>();
        boolean flag = true;
        while(!stack.isEmpty() || temp!=null){
            if(temp!= null){
                if()
                stack.push(temp);
                temp = temp.leftNode;
            }
            else{
                temp = stack.pop();
                temp = temp.rightNode;
            }
        }
        return root;
    }

    public static TreeNode BulidTree(int [] arr,int index){
        if(index >= arr.length || arr[index]==-1) return null;
        TreeNode root = new TreeNode(arr[index]);
        root.leftNode = BulidTree(arr,index*2+1);
        root.rightNode = BulidTree(arr,index*2+2);
        return root;
    }
    public static void preTraverse(TreeNode root){
        if(root == null) return;
        System.out.printf("%d\t",root.value);
        preTraverse(root.leftNode);
        preTraverse(root.rightNode);

    }
    public static void midTraverse(TreeNode root){
        if(root == null) return;
        midTraverse(root.leftNode);
        System.out.printf("%d\t",root.value);
        midTraverse(root.rightNode);

    }
}
