package TencentOffer.CH3.Problem18_Tree;

import java.util.*;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/7 17:04;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class SymmetricBinaryTree {

    public static void main(String [] args){
        int [] arr = {1,2,2,-1,3,3};
//        int [] arr = {1,0};

        TreeNode tree = BulidTree(arr,0);
        System.out.println(isSymmetricTree(tree));
    }

    public static boolean isSymmetricTreeR(TreeNode root1,TreeNode root2){
        if(root1 == null&& root2 == null)
            return true;
        if(root1== null || root2 == null)
            return false;

        if(root1.value == root2.value){
            return isSymmetricTreeR(root1.leftNode,root2.rightNode)&&
                    isSymmetricTreeR(root1.rightNode,root2.leftNode);
        }
        else
            return false;
    }

    public static boolean isSymmetricTree(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.leftNode);
        stack.push(root.rightNode);
        while (!stack.empty()) {
            TreeNode n1 = stack.pop(), n2 = stack.pop();
            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null || n1.value != n2.value) return false;
            stack.push(n1.leftNode);
            stack.push(n2.rightNode);
            stack.push(n1.rightNode);
            stack.push(n2.leftNode);
        }
        return true;
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
