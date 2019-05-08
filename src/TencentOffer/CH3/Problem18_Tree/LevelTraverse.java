package TencentOffer.CH3.Problem18_Tree;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/8 8:59;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class LevelTraverse {

    public static void main(String [] args){
        int [] arr = {-8,-6,7,6,-1,-1,-1,-1,5};
        TreeNode root = BulidTree(arr,0);
        levelprint(root);
    }

    public static TreeNode BulidTree(int [] arr,int index){
        if(index >= arr.length || arr[index]==-1) return null;
        TreeNode root = new TreeNode(arr[index]);
        root.leftNode = BulidTree(arr,index*2+1);
        root.rightNode = BulidTree(arr,index*2+2);
        return root;
    }
    //二叉树按层输出
    public static void levelprint(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode boader = node;
        queue.offer(node);
        while(!queue.isEmpty()){
            node = queue.remove();
            if(node.leftNode != null){
                queue.offer(node.leftNode);
            }
            if(node.rightNode != null){
                queue.offer(node.rightNode);

            }
            System.out.printf("%2d\t",node.value);
            if(node == boader){
                System.out.println();
                if(boader.rightNode!=null)
                    boader = boader.rightNode;
                else{
                    boader = boader.leftNode;
                }
            }
        }

    }
}
