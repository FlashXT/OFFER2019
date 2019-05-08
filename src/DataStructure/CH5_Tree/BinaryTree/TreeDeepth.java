package DataStructure.CH5_Tree.BinaryTree;

public class TreeDeepth {
    public static void main(String [] args){
        Integer [] arr = {1,2,3};
        BinaryTree<Integer> tree = new BinaryTree<>(arr);
        System.out.println(treeDeepth(tree.root));
    }
    public static int treeDeepth(TreeNode root){
        if(root == null)
            return 0;
        return 1+Math.max(treeDeepth(root.leftnode),treeDeepth(root.rightnode));
    }
}
