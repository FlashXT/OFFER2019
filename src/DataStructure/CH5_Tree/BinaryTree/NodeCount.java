package DataStructure.CH5_Tree.BinaryTree;

public class NodeCount {
    public static void main(String [] args){
        Integer [] arr = {1,2,3,4,5,6,7,-1,8};
        BinaryTree<Integer> tree = new BinaryTree<>(arr);
        System.out.println(count(tree.root));
    }
    public static int count(TreeNode root){
        if(root == null)
            return 0;
        return 1+count(root.leftnode)+count(root.rightnode);
    }
}
