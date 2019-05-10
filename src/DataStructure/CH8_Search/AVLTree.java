package DataStructure.CH8_Search;

/************************************************************************
 * 平衡二叉树（Balanced Binary Tree）:
 *      平衡二叉搜索树（Self-balancing binary search tree）又被称为AVL树（有别
 *   于AVL算法），且具有以下性质：它是一 棵空树或它的左右两个子树的高度差的绝对值不超
 *   过1，并且左右两个子树都是一棵平衡二叉树。
 *   平衡因子(bf)：结点的左子树的深度减去右子树的深度，那么显然-1<=bf<=1;
 *
 * 平衡调整：
 *    ①对P结点的左儿子的左子树进行一次插入       <--- 右旋
 *    ②对P结点的左儿子的右子树进行一次插入       <--- 先左旋再右旋
 *    ③对P结点的右儿子的左子树进行一次插入       <--- 先右旋再左旋
 *    ④对P结点的右儿子的右子树进行一次插入       <--- 左旋
 *
 ************************************************************************/

class AVLTreeNode<T>{
    public T item;
    public int bf;
    public AVLTreeNode leftnode;
    public AVLTreeNode rightnode;
    public AVLTreeNode(T item){
        this.item = item;
        this.bf = 0;
        this.leftnode = null;
        this.rightnode = null;

    }
}
public class AVLTree {
    public static void main(String [] args){
        int [] arr = {4,1,2,3,-1,5,9,6,7,12,11};
        AVLTreeNode<Integer> root = bulidAVLTree(arr);
        midTraverse(root);
        System.out.println();

        System.out.println("AAAAA");
    }
    public static AVLTreeNode<Integer> bulidAVLTree(int [] arr){
        AVLTreeNode root= new AVLTreeNode(arr[0]);
        for(int i = 0; i < arr.length;i++)
            insertAVLTree(root,arr[i]);
        return root;

    }
    public static AVLTreeNode<Integer> insertAVLTree(AVLTreeNode<Integer> root,int value){
        if(root == null)
            return new AVLTreeNode<>(value);

        else{
            if(value < root.item){
                root.bf+=1;
                root.leftnode = insertAVLTree(root.leftnode,value);
                //左边
                if(root.bf > 1){

                }
                else if(root.bf < -1){

                }
            }
            else if (value > root.item){
                root.bf-=1;
                root.rightnode = insertAVLTree(root.rightnode,value);
            }
        }
        return root;
    }
    public static void rebalanced(AVLTreeNode node, int insertedKey) {
        balancedFactor = getBalancedFactor(node);
        if (balancedFactor > 1 && insertedKey < node.key)
            return rightRotation(node);     //case 1
        if (balancedFactor < -1 && insertedKey > node.key)
            return leftRotation(node);      //case 4

        // ......
        // miss other 2 possibilities

        // if do not need rebalanced (all conditions cannot satisfied)
        // then return the current node
        return node;
    }
    //中序遍历
    public static void midTraverse(AVLTreeNode root){
        if(root!=null){
            midTraverse(root.leftnode);
            System.out.printf("%d\t",root.bf);
//            System.out.printf("%d\t",root.item);
            midTraverse(root.rightnode);
        }
    }
}
