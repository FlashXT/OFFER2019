package P01_DataStructure.CH5_Tree.BinaryTree;

public class isSameTree {
    public static void main(String [] args){
        Integer [] arr = {1,2,3,4,5};
        BinaryTree<Integer> tree = new BinaryTree<>(arr);
        Integer [] arr2 = {1,2,3,4};
        BinaryTree<Integer> tree2 = new BinaryTree<>(arr2);

        System.out.println(isSameTree(tree.root,tree2.root));
    }
    public static boolean isSameTree(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        if(root1.item == root2.item){
            return isSameTree(root1.leftnode,root2.leftnode)&&
                    isSameTree(root1.rightnode,root2.rightnode);
        }
        else return false;
    }
}
