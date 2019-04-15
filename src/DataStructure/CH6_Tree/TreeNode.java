package DataStructure.CH6_Tree;

public final class TreeNode<T> {
    TreeNode leftnode;
    T item;
    TreeNode rightnode;
    public TreeNode(T item){
        leftnode = null;
        this.item = item;
        rightnode =null;
    }

}
