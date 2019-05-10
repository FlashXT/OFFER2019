package DataStructure.CH8_Search;

import java.net.Inet4Address;

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
        int [] arr = {4,1,2,3,-1,5,9,6};
//        int [] arr = {12,24,37,45,53,93};
        AVLTreeNode<Integer> root = bulidAVLTree(arr);
        midTraverse(root);
        System.out.println();
        remove(root,4);
        midTraverse(root);
        System.out.println();


    }

    //建立平衡二叉树
    public static AVLTreeNode<Integer> bulidAVLTree(int [] arr){
        AVLTreeNode root= null;
        for(int i = 0; i < arr.length;i++)
           root = insertAVLTree(root,arr[i]);
        return root;

    }
    //向平衡二叉树中插入元素
    public static AVLTreeNode<Integer> insertAVLTree(AVLTreeNode<Integer> root,int value){
        if(root == null)
            return new AVLTreeNode<>(value);

        else{
            if(value < root.item){

                root.leftnode = insertAVLTree(root.leftnode,value);
                root.bf = updateBF(root);
                if(root.bf >= 2){
                    if(root.leftnode.bf == 1)
                        root = RR(root);
                    else
                        root = LR(root);

                }

            }
            else if (value > root.item){

                root.rightnode = insertAVLTree(root.rightnode,value);
                root.bf = updateBF(root);
                if(root.bf <= -2){
                    if(root.rightnode.bf == -1)
                        root = LL(root);
                    else
                        root = RL(root);
                }

            }
        }
        return root;
    }
    //AVL树查找(同二叉排序树)
    public static Boolean Search(TreeNode<Integer> root,int key){
        if(root == null)
            return false;
        if(root.item == key)
            return true;
        else if(root.item > key)
            return Search(root.leftnode,key);
        else
            return Search(root.rightnode,key);
    }
    //删除结点
    public static AVLTreeNode<Integer> remove(AVLTreeNode<Integer> root, int value) {
        // 根为空 或者 没有要删除的节点，直接返回null。
        if (root ==null)
            return null;
        // 待删除的节点在"root的左子树"中
        if (root.item > value) {
            root.leftnode = remove(root.leftnode, value);
            // 删除节点后，若AVL树失去平衡，则进行相应的调节。
            root.bf = updateBF(root);
            if (root.bf == 2) {
                AVLTreeNode<Integer> r =  root.rightnode;
                r.leftnode.bf = updateBF(r.leftnode);
                r.rightnode.bf = updateBF(r.rightnode);

                if ( r.leftnode.bf > r.rightnode.bf)
                    root = RL(root);
                else
                    root = RR(root);
            }
        }
        // 待删除的节点在"tree的右子树"中
        else if (root.item < value) {
            root.rightnode = remove(root.rightnode,value);
            // 删除节点后，若AVL树失去平衡，则进行相应的调节。
            root.bf = updateBF(root);
            if (root.bf == 2) {
                AVLTreeNode<Integer> l =  root.leftnode;
                l.leftnode.bf = updateBF(l.leftnode);
                l.rightnode.bf = updateBF(l.rightnode);

                if (l.rightnode.bf > l.leftnode.bf)
                    root =LR(root);
                else
                    root = LL(root);
            }

        }
        //root是对应要删除的节点。
        else {
            // tree的左右孩子都非空
            if ((root.leftnode!=null) && (root.rightnode!=null)) {
                if (root.bf > 0) {
                    // 如果tree的左子树比右子树高；
                    // 则(01)找出tree的左子树中的最大节点;
                    //   (02)将该最大节点的值赋值给tree;
                    //   (03)删除该最大节点;
                    // 这类似于用"tree的左子树中最大节点"做"tree"的替身；
                    // 采用这种方式的好处是：删除"tree的左子树中最大节点"之后，AVL树仍然是平衡的。
                    AVLTreeNode<Integer> max = maximum(root.leftnode);
                    root.item = max.item;
                    root.leftnode = remove(root.leftnode, max.item);
                } else {
                    // 如果tree的左子树不比右子树高(即它们相等，或右子树比左子树高1)
                    // 则(01)找出tree的右子树中的最小节点
                    //   (02)将该最小节点的值赋值给tree。
                    //   (03)删除该最小节点。
                    // 这类似于用"tree的右子树中最小节点"做"tree"的替身；
                    // 采用这种方式的好处是：删除"tree的右子树中最小节点"之后，AVL树仍然是平衡的。
                    AVLTreeNode<Integer> min = maximum(root.rightnode);
                    root.item = min.item;
                    root.rightnode = remove(root.rightnode, min.item);
                }
            } else {
                AVLTreeNode<Integer> tmp = root;
                root = (root.leftnode!=null) ? root.leftnode: root.rightnode;
                tmp = null;
            }
        }

        return root;
    }
    //单右旋转
    private static AVLTreeNode<Integer> RR(AVLTreeNode<Integer> node){
        AVLTreeNode<Integer> temp = node.leftnode;
        node.leftnode = temp.rightnode;
        temp.rightnode = node;
        node.bf = updateBF(node);
        temp.bf = updateBF(temp);
        return temp;		//返回新的根
    }
    //先左旋再右旋
    public static AVLTreeNode<Integer> LR(AVLTreeNode<Integer> node){
        node.leftnode =LL(node.leftnode);
        node = RR(node);
        return node;
    }
    //单左旋转
    private static AVLTreeNode<Integer> LL(AVLTreeNode<Integer> node){
        AVLTreeNode<Integer> temp = node.rightnode;
        node.rightnode = temp.leftnode;
        temp.leftnode = node;

        node.bf = updateBF(node);
        temp.bf = updateBF(temp);
        return temp;		//返回新的根
    }
    //先右旋再左旋
    public static AVLTreeNode<Integer> RL(AVLTreeNode<Integer> node){
        node.rightnode =RR(node.rightnode);
        node = LL(node);
        return node;

    }
    public static int updateBF(AVLTreeNode<Integer> node){

        return getDeepth(node.leftnode)-getDeepth(node.rightnode);

    }
    public static int getDeepth(AVLTreeNode root){
        if(root == null) return 0;
        return Math.max(getDeepth(root.leftnode),getDeepth(root.rightnode))+1;

    }

    //查找最大结点：返回root为根结点的AVL树的最大结点。
    private static AVLTreeNode<Integer> maximum(AVLTreeNode<Integer> root) {
        if (root == null)
            return null;

        while(root.rightnode != null)
            root = root.rightnode;
        return root;
    }
    // 查找最小结点：返回tree为根结点的AVL树的最小结点。
    private static AVLTreeNode<Integer> minimum(AVLTreeNode<Integer> root) {
        if (root == null)
            return null;

        while(root.leftnode != null)
            root = root.leftnode;
        return root;
    }
    //中序遍历
    public static void midTraverse(AVLTreeNode root){
        if(root!=null){
            midTraverse(root.leftnode);
//            System.out.printf("%d\t",root.bf);
            System.out.printf("%d\t",root.item);
            midTraverse(root.rightnode);
        }
    }
}
