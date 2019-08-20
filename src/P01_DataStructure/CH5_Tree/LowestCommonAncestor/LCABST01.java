package P01_DataStructure.CH5_Tree.LowestCommonAncestor;


/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/5/19 13:57
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
/********************************************************************
 * LCA问题1：在二叉搜索树中，查找两个结点（u,v）的最近公共祖先，此时分三种情况：
 *     ①(u,v)位于root的同一子树，那么在root的该子树上递归查找；
 *     ②(u,v)位于root的不同子树，此时又分2种情况：
 *          a.u,v均位于root的子树；
 *          b.u(或v)为root结点，v(或u)为子树上的结点；
 *       此时直接返回root，即为u,v的最近公共祖先结点
 *******************************************************************/

public class LCABST01 {
    public static void main(String [] args){
        int [] arr = {13,21,43,23,37,45,52,48,64,87};
        TreeNode tree = new BinarySearchTree().bulidBST(arr);
        TreeNode node1 = new TreeNode(43);
        TreeNode node2 = new TreeNode(43);

        System.out.println(LCA(tree,node1,node2).item);


    }
    public static  TreeNode LCA(TreeNode root,TreeNode u,TreeNode v){
        if(root == null || u==null || v == null) return null;
        //①u,v 位于root的同一个子树
        if(u.item < root.item && v.item < root.item)
            return LCA(root.leftnode,u,v);
        if(u.item > root.item && v.item > root.item)
            return LCA(root.rightnode,u,v);
        //②u,v位于root的不同子树
        return root;
    }
}
