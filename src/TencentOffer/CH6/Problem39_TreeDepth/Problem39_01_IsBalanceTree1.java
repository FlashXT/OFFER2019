package TencentOffer.CH6.Problem39_TreeDepth;

import TencentOffer.TreeNode;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/15 8:39;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Problem39_01_IsBalanceTree1 {
    public static void main(String [] args){
        int [] arr = {1,2,-1,4,5,-1,6,-1,-1,7};
        TreeNode root =BulidTree(arr,0);
        System.out.println(IsBalanced(root));
    }
    public static Boolean IsBalanced(TreeNode root){
        if(root == null)
            return true;
        int left = TreeDepth(root.leftNode);
        int right = TreeDepth(root.rightNode);
        if(Math.abs(left - right) <=1)
            return IsBalanced(root.leftNode)&&IsBalanced(root.rightNode);
        return false;

    }

    public static int TreeDepth(TreeNode root){
        if(root == null)
            return 0;
        return 1+Math.max(TreeDepth(root.leftNode),TreeDepth(root.rightNode));
    }
    public static TreeNode BulidTree(int [] arr,int index){
        if(index >= arr.length || arr[index]==-1)
            return null;
        TreeNode root = new TreeNode(arr[index]);
        root.leftNode = BulidTree(arr,2*index+1);
        root.rightNode = BulidTree(arr,2*index+2);
        return root;
    }
}
