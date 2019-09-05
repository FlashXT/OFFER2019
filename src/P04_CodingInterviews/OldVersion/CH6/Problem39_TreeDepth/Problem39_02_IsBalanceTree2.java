package P04_CodingInterviews.OldVersion.CH6.Problem39_TreeDepth;

import P04_CodingInterviews.HelpClass.TreeNode;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/15 8:39;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Problem39_02_IsBalanceTree2 {

    public static void main(String [] args){
        int [] arr = {1,2,3,4,5,-1,6,-1,-1,7};
        TreeNode root =BulidTree(arr,0);
        System.out.println(IsBalanced_Solution(root));
    }
    public static boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root)!=-1;
    }
    public static int getDepth(TreeNode root){
        if(root == null)   return 0;

        int left =getDepth(root.left);
        if(left == -1)     return -1;
        int right=getDepth(root.right);
        if(right == -1)    return -1;

        if(Math.abs(left-right)<=1)
            return  1+Math.max(left,right);

        return -1;

    }

    public static TreeNode BulidTree(int [] arr,int index){
        if(index >= arr.length || arr[index]==-1)
            return null;
        TreeNode root = new TreeNode(arr[index]);
        root.left = BulidTree(arr,2*index+1);
        root.right = BulidTree(arr,2*index+2);
        return root;
    }
}
