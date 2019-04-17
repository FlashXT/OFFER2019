package DataStructure.CH6_Tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/****************************************************************************
 * 二叉树的层次遍历，层次输出，直观打印，边界结点打印；
 * **************************************************************************/
public class treeTraverse3 {
    public static void main(String [] args){
        Integer [] arr  ={1,2,3,4,5,6,7,8,9,10,11};
        BinaryTree<Integer> tree = new BinaryTree<>(arr);

        leveltraversal(tree.root);
        levelprint(tree.root);

    }
    //二叉树的层次遍历
    public static void leveltraversal(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            node = queue.remove();
            if(node.leftnode != null){
                queue.offer(node.leftnode);
            }
            if(node.rightnode != null){
                queue.offer(node.rightnode);
            }
            System.out.printf("%2d\t",node.item);
        }
        System.out.println();

    }
    //二叉树按层输出
    public static void levelprint(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode boader = node;
        queue.offer(node);
        while(!queue.isEmpty()){
            node = queue.remove();
            if(node.leftnode != null){
                queue.offer(node.leftnode);
            }
            if(node.rightnode != null){
                queue.offer(node.rightnode);

            }
            System.out.printf("%2d\t",node.item);
            if(node == boader){
                System.out.println();
                boader = boader.rightnode;
            }
        }

    }

}
