package P01_DataStructure.CH8_Search.AVLTree;

import java.util.Comparator;

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

public class AVLTree<T> {
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
    public AVLTreeNode<T> root;
    private Comparator<T> comparator;
    public AVLTree(){}

    public AVLTree(T[] arr){

        this.root = bulidAVLTree(arr);
        this.comparator = null;
    }
    public AVLTree(T[] arr, Comparator<T> comparator){
        this.comparator = comparator;
        this.root = bulidAVLTree(arr);

    }

    //建立平衡二叉树
    public AVLTreeNode<T> bulidAVLTree(T [] arr){
        AVLTreeNode root= null;
        for(int i = 0; i < arr.length;i++)
           root = insertAVLTree(root,arr[i]);
        return root;

    }
    //平衡二叉树中插入元素
    public AVLTreeNode<T> insertAVLTree(AVLTreeNode<T> root,T value){

        if(root == null)
            return new AVLTreeNode<>(value);

        else{
            int com = 0;
            if(this.comparator == null)
                com = this.Compataor(root.item,value);

            else
                com = this.comparator.compare(root.item,value);
            if(com > 0){

                root.leftnode = insertAVLTree(root.leftnode,value);
                root.bf = updateBF(root);
                if(root.bf >= 2){
                    if(root.leftnode.bf == 1)
                        root = RR(root);
                    else
                        root = LR(root);

                }

            }
            else if (com < 0){

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

    public Boolean Search(T key){
        return Search(this.root,key);

    }
    private Boolean Search(AVLTreeNode<T> root,T value){
        if(root == null)
            return false;
        int com = 0;
        if(this.comparator == null)
            com = this.Compataor(root.item,value);

        else
            com = this.comparator.compare(root.item,value);
        if(com == 0)
            return true;
        else if(com > 0)
            return Search(root.leftnode,value);
        else
            return Search(root.rightnode,value);
    }
    //删除结点
    public  Boolean RemoveNode(T value){

        if(Search(value)== true){
            this.root = remove(this.root,value);
            return true;
        }
        else
            return false;

    }
    //参考：https://www.cnblogs.com/skywang12345/p/3577479.html#a2
    private AVLTreeNode<T> remove(AVLTreeNode<T> root, T value) {
        // 根为空 或者 没有要删除的节点，直接返回null。
        if (root ==null)
            return null;
        int com = 0;
        if(this.comparator == null)
            com = this.Compataor(root.item,value);

        else
            com = this.comparator.compare(root.item,value);
        // 待删除的节点在"root的左子树"中
        if (com >0) {
            root.leftnode = remove(root.leftnode, value);
            // 删除节点后，若AVL树失去平衡，则进行相应的调节。
            if(root !=null){
                root.bf = updateBF(root);
                if (root.bf == -2) {
                    AVLTreeNode<Integer> r =  root.rightnode;

                    if ( r.rightnode.bf == 1)
                        root = RL(root);
                    else
                        root = LL(root);
                }
            }

        }
        // 待删除的节点在"tree的右子树"中
        else if (com < 0) {
            root.rightnode = remove(root.rightnode,value);
            // 删除节点后，若AVL树失去平衡，则进行相应的调节。
            if(root != null){
                root.bf = updateBF(root);
                if (root.bf == 2) {
                    AVLTreeNode<T> l =  root.leftnode;

                    if ( l.leftnode.bf == -1)
                        root =LR(root);
                    else
                        root = RR(root);
                }
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
                    AVLTreeNode<T> max = maximum(root.leftnode);
                    root.item = max.item;
                    root.leftnode = remove(root.leftnode, max.item);
                } else {
                    // 如果tree的左子树不比右子树高(即它们相等，或右子树比左子树高1)
                    // 则(01)找出tree的右子树中的最小节点
                    //   (02)将该最小节点的值赋值给tree。
                    //   (03)删除该最小节点。
                    // 这类似于用"tree的右子树中最小节点"做"tree"的替身；
                    // 采用这种方式的好处是：删除"tree的右子树中最小节点"之后，AVL树仍然是平衡的。
                    AVLTreeNode<T> min = minimum(root.rightnode);
                    root.item = min.item;
                    root.rightnode = remove(root.rightnode, min.item);
                }
            } else {
                root = (root.leftnode!=null) ? root.leftnode: root.rightnode;
            }
        }

        return root;
    }
    //左左右旋转
    private AVLTreeNode<T> RR(AVLTreeNode<T> node){
        AVLTreeNode<T> temp = node.leftnode;
        node.leftnode = temp.rightnode;
        temp.rightnode = node;
        node.bf = updateBF(node);
        temp.bf = updateBF(temp);
        return temp;		//返回新的根
    }
    //左右先左再右旋
    public  AVLTreeNode<T> LR(AVLTreeNode<T> node){
        node.leftnode =LL(node.leftnode);
        node = RR(node);
        return node;
    }
    //右右左旋转
    private  AVLTreeNode<T> LL(AVLTreeNode<T> node){
        AVLTreeNode<T> temp = node.rightnode;
        node.rightnode = temp.leftnode;
        temp.leftnode = node;

        node.bf = updateBF(node);
        temp.bf = updateBF(temp);
        return temp;		//返回新的根
    }
    //右左先右再左旋
    public  AVLTreeNode<T> RL(AVLTreeNode<T> node){
        node.rightnode =RR(node.rightnode);
        node = LL(node);
        return node;

    }
    public  int updateBF(AVLTreeNode<T> node){
        if(node.leftnode == null && node.rightnode == null)
            return 0;
        else if(node.leftnode == null || node.rightnode == null)
            return node.leftnode == null ? -getDeepth(node.rightnode):getDeepth(node.leftnode);
        else
            return getDeepth(node.leftnode) - getDeepth(node.rightnode);

    }
    public int getDeepth(AVLTreeNode<T> root){
        if(root == null) return 0;
        return Math.max(getDeepth(root.leftnode),getDeepth(root.rightnode))+1;

    }

    //查找最大结点：返回root为根结点的AVL树的最大结点。
    private  AVLTreeNode<T> maximum(AVLTreeNode<T> root) {
        if (root == null)
            return null;

        while(root.rightnode != null)
            root = root.rightnode;
        return root;
    }
    // 查找最小结点：返回tree为根结点的AVL树的最小结点。
    private  AVLTreeNode<T> minimum(AVLTreeNode<T> root) {
        if (root == null)
            return null;

        while(root.leftnode != null)
            root = root.leftnode;
        return root;
    }

    //先序遍历
    public  void preTraverse(){
        preTraverse(this.root);
        System.out.println();
    }
    private  void preTraverse(AVLTreeNode<T> root){
        if(root!=null){
            System.out.printf("%s\t",root.item.toString());
            preTraverse(root.leftnode);
            preTraverse(root.rightnode);
        }
    }
    //中序遍历
    public  void midTraverse(){
        midTraverse(this.root);
        System.out.println();
    }
    private  void midTraverse(AVLTreeNode<T> root){
        if(root!=null){
            midTraverse(root.leftnode);
//            System.out.printf("%d\t",root.bf);
            System.out.printf("%s\t",root.item.toString());
            midTraverse(root.rightnode);
        }
    }
    //参考PriorityQueue源码
    private  int Compataor(T o1,T o2){
        Comparable<? super T> key = (Comparable<? super T>)o1;
        return key.compareTo(o2);
    }
}
