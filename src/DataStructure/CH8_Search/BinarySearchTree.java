package DataStructure.CH8_Search;

/**********************************************************************************
 *                              二叉排序树
 * 1.定义：
 *    二叉排序树或者是一棵空树，或者是具有下列性质的二叉树：
 *      （1）若左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 *      （2）若右子树不空，则右子树上所有结点的值均大于或等于它的根结点的值；
 *      （3）左、右子树也分别为二叉排序树；
 *2.查找过程：
 *    二叉排序树的查找可以用递归来实现:
 *     先将要查找的关键字和根节点进行比较;
 *          若和根节点值相同，则返回根节点值；
 *          若比根节点小，就递归查找左子树;
 *          若比根节点大，则递归查找右子树。
 *3.插入：
 *      二叉排序树是一种动态树表。其特点是，树的结构通常不是一次生成的，而是在查找过程中，
 *      当树中不存在关键字等于给定值的结点时再进行插入。新插入的结点一定是一个新添加的叶
 *      子结点，并且是查找不成功时查找路径上访问的最后一个结点的左孩子或右孩子结点。
 *
 *      先调用查找操作将要插入的关键字进行比较：
 *         如果在原有的二叉排序树中没有要插入的关键字，则将关键字与查找的结点p（在查找操
 *         作中返回的结点）的值进行比较：
 *              若p为空，则插入关键字赋值给该节点；
 *              若小于结点p的值，则插入关键字作为结点p的左子树；
 *              若大于结点p的值，则插入关键字作为结点p的右子树；
 *4.删除：
 *      二叉排序树的删除操作相对复杂，因为不能因为删除了结点，让这颗二叉排序树变得不满足二叉
 *      排序树的性质，所以对于二叉排序树的 P结点 存在三种情况：
 *          ① P结点为 叶子结点；（直接删除P结点即可）
 *          ② P结点 仅有左或者右子树的结点；（删除P结点后，将它的左子树或者右子树整个移动到
 *             删除结点的位置）
 *          ③ P结点 既有左子树又右子树：（将P结点的直接前驱或者直接后继作为删除结点的数据）
 *
 ***********************************************************************************/

public class BinarySearchTree {
    public static void main(String [] args){
        int [] arr = {4,1,2,3,-1,5,9,6,7,12,11};

        TreeNode<Integer> root = bulidBST(arr);
        midTraverse(root);
        System.out.println();
        System.out.println(Search(root,12));

        System.out.println(Delete(root,-1));
        midTraverse(root);
        System.out.println();
        System.out.println(Delete(root,6));
        midTraverse(root);
        System.out.println();
        System.out.println(Delete(root,9));
        midTraverse(root);
        System.out.println();

    }

    //二叉排序树建立
    public static TreeNode<Integer> bulidBST(int [] arr){
        TreeNode root= new TreeNode(arr[0]);
        for(int i = 1; i < arr.length;i++)
            insertBST(root,arr[i]);
        return root;

    }

    //二叉排序树插入
    public static TreeNode<Integer> insertBST(TreeNode<Integer> root,int value){
        if (root == null){
            return new TreeNode(value);
        }
        else{
            if(value < root.item){
                root.leftnode = insertBST(root.leftnode,value);
            }
            else if (value > root.item){
                root.rightnode = insertBST(root.rightnode,value);
            }
        }
        return root;
    }
    //中序遍历
    public static void midTraverse(TreeNode root){
        if(root!=null){
            midTraverse(root.leftnode);
            System.out.printf("%d\t",root.item);
            midTraverse(root.rightnode);
        }
    }

    //二叉排序树查找
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

    //二叉排序树删除
    public static Boolean Delete(TreeNode<Integer> root,int key){

        TreeNode<Integer> pnode = SearchPNode(root,key);
        TreeNode<Integer> dnode;

        if(pnode!= null){
            if(pnode.item < key)
                dnode = pnode.rightnode;
            else
                dnode = pnode.leftnode;
            //①P结点 为叶子结点
            if(dnode.leftnode == null && dnode.rightnode == null){
                if(pnode.leftnode != null && pnode.leftnode.item == dnode.item)
                    pnode.leftnode = null;
                else
                    pnode.rightnode = null;
            }
            //②P结点 仅有左或者右子树的结点
            else if(dnode.leftnode == null || dnode.rightnode == null){
                if(dnode.leftnode != null){
                    if(pnode.leftnode != null && pnode.leftnode.item == dnode.item)
                        pnode.leftnode = dnode.leftnode;
                    else
                        pnode.rightnode = dnode.leftnode;
                }else{
                    if(pnode.leftnode != null && pnode.leftnode.item == dnode.item)
                        pnode.leftnode = dnode.rightnode;
                    else
                        pnode.rightnode = dnode.rightnode;
                }
            }
            //③P结点 既有左子树又右子树:将P结点的直接前驱或者直接后继作为删除结点的数据
            //那么如何找到P结点的前驱或者后继？画图寻找二叉树中的L型结构！！！
            else{
                //前驱解法
//                TreeNode<Integer> q = dnode;
//                TreeNode<Integer> s = dnode.leftnode;
//                while(s.rightnode!=null){
//                    q = s;
//                    s = s.rightnode;
//                }
//                dnode.item = s.item;
//                if(q != dnode) q.rightnode = s.leftnode;
                //后继解法
                TreeNode<Integer> q = dnode;
                TreeNode<Integer> s = dnode.rightnode;
                while(s.leftnode!=null){
                    q = s;
                    s = s.leftnode;
                }
                dnode.item = s.item;
                if(q != dnode) q.leftnode = s.rightnode;

            }
            return true;
        }

        return false;
    }
    //查找删除结点的父结点
    private static TreeNode<Integer> SearchPNode(TreeNode<Integer> node,int key){
        if(node.leftnode == null&&node.rightnode == null )
            return null;
        if(node.leftnode != null && (int)node.leftnode.item == key){
            return node;
        }
        if( node.rightnode != null && (int)node.rightnode.item == key )
            return node;
        else if(node.item > key)
            return SearchPNode(node.leftnode,key);
        else
            return SearchPNode(node.rightnode,key);
    }

    public static void swap(int [] arr, int index1,int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
