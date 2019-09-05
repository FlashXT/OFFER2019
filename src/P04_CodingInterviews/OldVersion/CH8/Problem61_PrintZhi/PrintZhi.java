package P04_CodingInterviews.OldVersion.CH8.Problem61_PrintZhi;

import java.util.ArrayList;
import java.util.Stack;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/5/16 20:21
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class PrintZhi {
    public static  void main(String [] args){
        int [] arr = {1,2,-1,4,5,6,7,8,9,10,11,12,13,14,15};
        TreeNode root = BulidTree(arr,0);
//        preTraverse(root);
        PrintZhi(root);
        System.out.println();
    }
    public static ArrayList<ArrayList<Integer>> PrintZhi(TreeNode root){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            while(!stack1.isEmpty()){
                if(stack1.peek().left!=null)
                    stack2.push(stack1.peek().left);
                System.out.printf("%d\t",stack1.peek().val);
                if(stack1.peek().right!=null)
                    stack2.push(stack1.peek().right);
                temp.add(stack1.pop().val);
            }
            System.out.println();
            if(temp.size()!=0){
                res.add(new ArrayList<>(temp));
                temp.clear();
            }

            while(!stack2.isEmpty()){
                if(stack2.peek().right!=null)
                    stack1.push(stack2.peek().right);
                System.out.printf("%d\t",stack2.peek().val);
                if(stack2.peek().left!=null)
                    stack1.push(stack2.peek().left);
                temp.add(stack2.pop().val);
            }
            System.out.println();
            if(temp.size()!=0){
                res.add(new ArrayList<>(temp));
                temp.clear();
            }

        }
        return res;
    }
    public static  TreeNode BulidTree(int [] arr,int index){
        if(index >= arr.length || arr[index]==-1)
            return null;
        TreeNode root = new TreeNode(arr[index]);
        root.left = BulidTree(arr,index*2+1);
        root.right = BulidTree(arr,index*2+2);
        return root;

    }
    public static void preTraverse(TreeNode root){
        if(root != null){
            System.out.println(root.val);
            preTraverse(root.left);
            preTraverse(root.right);
        }
    }
}
