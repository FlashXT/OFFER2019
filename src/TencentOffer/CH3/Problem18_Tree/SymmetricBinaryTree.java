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
        int [] arr = {1,2,2,3,4,4,3};
//        int [] arr = {1,0};
        TreeNode tree = BulidTree(arr,0);
        System.out.println(isSymmetricTree(tree));
    }

    public static boolean isSymmetricTree(TreeNode root){
        if(root == null) return true;
        TreeNode temp = root;
        Queue<TreeNode> queue = new LinkedList<>();

        ArrayList<Integer> list = new ArrayList<>();
        queue.add(temp);
        TreeNode level = root;
        while(!queue.isEmpty()&& level!= null){
            temp = queue.remove();
            if(temp!= null){
                queue.add(temp.leftNode);
                queue.add(temp.rightNode);
            }
            while(temp == null && !queue.isEmpty()){
                list.add(-1);
                temp = queue.remove();
            }
            if(temp!=null)
                list.add(temp.value);

            if(temp == level){
                if(!isSymmetric(list))
                    return false;
                if(level.rightNode!= null)
                    level = level.rightNode;

            }

        }
        return true;
    }

    public static boolean isSymmetric(ArrayList<Integer> list){

        int length = list.size()-1;
        int i = 0;
        while(i< length-i){
            if(list.get(i) != list.get(length-i)){
                return false;
            }
            i++;
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
