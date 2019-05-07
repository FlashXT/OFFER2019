package TencentOffer.CH3.Problem18_Tree;

import java.util.Stack;


public class SubTree {
    public static void main(String [] main){
        int [] arr = {1,2,3,4,5,6,7,8};
        int [] arr2 = {1,2,3,4,8};
        TreeNode tree = BulidTree(arr,0);
        TreeNode subtree = BulidTree(arr2,0);
        System.out.println(isSubTree(tree,subtree));

    }

    public static boolean isSubTree(TreeNode treeroot,TreeNode subtreeroot){
        //如果要判断的子树为空，则返回true
        if(subtreeroot == null) return true;
        //如果要判断的子树不为空，树为空，返回false;
        if(subtreeroot != null && treeroot == null) return false;
        //如果根结点值相等，则判断左子树与右子树的值是否相等
        if(treeroot.value == subtreeroot.value){
            return isSubTree(treeroot.leftNode,subtreeroot.leftNode)&&
                    isSubTree(treeroot.rightNode,subtreeroot.rightNode);
        }
        //如果根结点的值不相等，则在树的左子树或右子树上寻找是否存在该子树
        else{
            return isSubTree(treeroot.leftNode,subtreeroot)||
                    isSubTree(treeroot.rightNode,subtreeroot);
        }

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
    public static void preTraverse2(TreeNode root){
        TreeNode temp = root;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty()|| temp != null){

           if(temp!= null){
               System.out.println(temp.value);
               stack.push(temp);
               temp = temp.leftNode;
           }
           else{
               temp = stack.pop();
               temp = temp.rightNode;
           }

        }
    }
}
