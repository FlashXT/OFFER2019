package DataStructure.CH9_Search;

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
public class AVLTree {
    public static void main(String [] args){
        System.out.println("AAAAA");
    }
}
