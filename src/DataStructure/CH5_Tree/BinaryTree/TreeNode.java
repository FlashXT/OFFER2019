package DataStructure.CH5_Tree.BinaryTree;

class TreeNode<T> {
    T item;
    TreeNode leftnode;
    TreeNode rightnode;
    public TreeNode(T item){
        this.item = item;
        this.leftnode = null;
        this.rightnode = null;

    }
}
