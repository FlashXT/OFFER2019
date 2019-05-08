package DataStructure.CH6_Tree.BinaryTree;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/****************************************************************************
 * 二叉树的层次遍历，层次输出，直观打印，边界结点打印；
 * 二叉树按层次打印的主要思路：
 *  该问题在层次遍历的基础上加上换行即可，那么问题的关键就是确定如何换行；
 *  思路：定义两个TreeNode类型的指针，last和nlast,其中last指向当前行的最右结点；nlast
 *  指向下一行的最右结点；nlast指向queue中最新压入的元素；当当前打印元素temp == last时，
 *  换行，并令last=nlast;
 ****************************************************************************/
public class treeTraverse3 {
    public static void main(String [] args){
        Integer [] arr  ={1,2,-1,3,-1,-1,-1,6};
        BinaryTree<Integer> tree = new BinaryTree<>(arr);
        ArrayList<Integer> list = new ArrayList<>();

        levelprint(tree.root);

    }
    //二叉树层次遍历，按层输出
    public static void levelprint(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        //last打印行的最右结点；nlast下一行的最右结点
        TreeNode last=root,nlast = root;
        queue.offer(root);
        TreeNode temp;
        int level = 0;
        System.out.print("Level "+level+++":");
        while(!queue.isEmpty()){
            temp = queue.remove();
            System.out.printf("%d\t",temp.item);

            if(temp.leftnode != null){
                nlast = temp.leftnode;
                queue.offer(temp.leftnode);
            }
            if(temp.rightnode != null){
                nlast = temp.rightnode;
                queue.offer(temp.rightnode);
            }
            if(temp == last && !queue.isEmpty()){
                System.out.print("\nLevel "+level+++":");
                last = nlast;
            }

        }

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


}
