package P04_CodingInterviews.OldVersion.CH8.Problem61_PrintZhi;

import java.util.ArrayList;
import java.util.Stack;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/5/16 20:21
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class PrintZhi2 {
    public static  void main(String [] args){
        int [] arr = {1,2,-1,4,5,6,7,8,9,10,11,12,13,14,15};
        TreeNode root = BulidTree(arr,0);
//        preTraverse(root);
        PrintZhi(root);
        System.out.println();
    }
    //代码太复杂，而且有问题
    public static ArrayList<ArrayList<Integer>> PrintZhi(TreeNode root){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        Stack<TreeNode> []stack = new Stack[2];
        stack[0] = new Stack<>();
        stack[1] = new Stack<>();

        int current = 0;
        stack[current].push(root);
        while(!stack[0].isEmpty() || !stack[1].isEmpty()){
            if(current == 0){
                if(stack[current].peek().left!=null)
                    stack[1-current].push(stack[current].peek().left);
                System.out.printf("%d\t",stack[current].peek().val);
                if(stack[current].peek().right!=null)
                    stack[1-current].push(stack[current].peek().right);
                temp.add(stack[current].pop().val);
            }
            else{
                if(stack[current].peek().right!=null)
                    stack[1-current].push(stack[current].peek().right);
                System.out.printf("%d\t",stack[current].peek().val);
                if(stack[current].peek().left!=null)
                    stack[1-current].push(stack[current].peek().left);
                temp.add(stack[current].pop().val);
            }
            if(stack[current].isEmpty()){
                current = 1- current;
                System.out.println();
                if(temp.size()!=0){
                    res.add(new ArrayList<>(temp));
                    temp.clear();
                }
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
