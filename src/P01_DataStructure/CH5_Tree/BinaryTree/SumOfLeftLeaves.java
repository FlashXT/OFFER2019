package P01_DataStructure.CH5_Tree.BinaryTree;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/5/19 9:26
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class SumOfLeftLeaves {
    public static void main(String [] args){
        Integer [] arr = {1,2,3,4,5};
        BinaryTree<Integer> tree = new BinaryTree<Integer>(arr);
        tree.preTraverse();
        System.out.println(SumofLeftLeaves(tree.root));

    }
    public static int SumofLeftLeaves(TreeNode<Integer> root){
        if(root == null) return 0;
        if(root.leftnode == null) return SumofLeftLeaves(root.rightnode);
        if(root.leftnode.leftnode == null && root.leftnode.rightnode == null)
              return (Integer)root.leftnode.item+SumofLeftLeaves(root.rightnode);

        return SumofLeftLeaves(root.leftnode)+SumofLeftLeaves(root.rightnode);
    }
    public static int SumofLeftLeaves2(TreeNode<Integer> root){
        if(root == null) return 0;
        if(root.leftnode!=null && root.leftnode.leftnode == null && root.leftnode.rightnode == null)
            return (Integer)root.leftnode.item+SumofLeftLeaves2(root.rightnode);

        return SumofLeftLeaves2(root.leftnode)+SumofLeftLeaves2(root.rightnode);
    }
}
