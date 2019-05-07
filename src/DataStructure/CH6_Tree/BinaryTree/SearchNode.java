package DataStructure.CH6_Tree.BinaryTree;

import org.omg.PortableInterceptor.INACTIVE;

public class SearchNode {
    public static void main(String [] args){
        Integer [] arr = {1,2,3,4,5,6,7,8,9};
        BinaryTree<Integer> tree = new BinaryTree<Integer>(arr);
        tree.preTraverse();
        System.out.println(searchNode(tree.root,8));

    }
    public static Boolean searchNode(TreeNode root, Integer value){
        if(root == null)
            return false;
        if(root.item == value)
            return true;
        else{
            return searchNode(root.leftnode,value)|| searchNode(root.rightnode,value);
        }

    }
}
