package DataStructure.CH5_Tree.BinaryTree;

public class TreeDepth {
    public static void main(String [] args){
        Integer [] arr = {1,2};
        BinaryTree<Integer> tree = new BinaryTree<>(arr);
        System.out.println(MaxDepth(tree.root));
        System.out.println(MinDepth(tree.root));
    }
    public static int MaxDepth(TreeNode root){
        if(root == null)
            return 0;
        return 1+Math.max(MaxDepth(root.leftnode),MaxDepth(root.rightnode));
    }
    public static int MinDepth(TreeNode root){
        if(root == null)
            return 0;
        if(root.leftnode == null && root.rightnode == null)
            return 1;
        if(root.leftnode == null)
            return 1+MinDepth(root.rightnode);
        if(root.rightnode == null)
            return 1+MinDepth(root.leftnode);
        return Math.min(MinDepth(root.leftnode),MinDepth(root.rightnode))+1;
    }
}
