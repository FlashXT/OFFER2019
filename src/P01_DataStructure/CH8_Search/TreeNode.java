package P01_DataStructure.CH8_Search;

public class TreeNode<T> {
    public T item;
    public TreeNode leftnode;
    public TreeNode rightnode;
    public TreeNode(T item){
        this.item = item;
        this.leftnode = null;
        this.rightnode = null;

    }
}
