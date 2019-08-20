package P01_DataStructure.CH5_Tree.LowestCommonAncestor;


/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/5/19 13:57
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/

import java.util.Stack;

/********************************************************************
 * LCA问题3：二叉树为普通的二叉树，每个结点不包含指向其父结点的指针；此时联想LCA
 * 问题2，主要问题是要获得从根节点到这连个结点的路径，要使用辅助空间；
 *******************************************************************/

public class LCABST03 {
    private static String path= "";
    public static void main(String [] args){
        int [] arr = {1,2,3,4,5,6,7,8,9};
        TreeNode root = bulidTree(arr,0);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(5);

        System.out.println(LCA(root,node1,node2).item);

    }
    public static  TreeNode LCA(TreeNode root,TreeNode node1,TreeNode node2){
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        boolean isnode1 = nodePath(root,stack,node1);
        boolean isnode2 = nodePath(root,stack2,node2);
//        stack = nodePath(root,node1);
//        stack2 = nodePath(root,node2);
        if(!isnode1 || !isnode2) return null;
        TreeNode res = null;
        for(int i = 0,j = 0; i <stack.size()&&j < stack2.size();i++,j++){
            if(stack.get(i)==stack2.get(j)){
                res = stack.get(i);
            }
        }
        return  res;
    }
    //在先序遍历的基础上更改而来
    public static Stack<TreeNode> nodePath(TreeNode root,TreeNode node) {
        if(root == null || node == null) return null;
        if(node == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null; //上一次出栈的结点
        TreeNode temp = root;
        // if用来压栈，else用来转向，逻辑清晰
        while(!stack.isEmpty() || temp != null){
            //temp 不空，将该结点入栈，沿着该结点的左孩子压栈
            if( temp!= null){
                if(temp.item == node.item)
                    break;
                stack.push(temp);
                temp = temp.leftnode;
            }
            //如果temp为空，转向
            else{
                //弹出此时的栈顶元素
                temp = stack.peek();
                //pre!=null &&temp.rightnode == pre表示上一个出栈元素是temp的右孩子时，temp才出栈
                //因为先序遍历遍历有孩子时，其父结点已经出栈，无法获取完整路径，因此这里需要改动
                while(temp.rightnode== null|| pre!=null &&temp.rightnode == pre){
                    pre = stack.pop();
                    temp = stack.peek();
                }
                temp = temp.rightnode;
            }
        }
        return stack;
    }
    public static boolean nodePath(TreeNode root,Stack<TreeNode> stack,TreeNode node) {
        if(root == null) return false;
        stack.push(root);
        if(root.item == node.item) return true;
        boolean b = false;
        //先去左子树找
        if(root.leftnode != null) b = nodePath(root.leftnode,stack,node);
        //左子树找不到并且右子树不为空的情况下才去找
        if(!b && root.rightnode != null) b = nodePath(root.rightnode,stack,node);
        //左右都找不到，弹出栈顶元素
        if(!b) stack.pop();
        return b;
    }
    public static TreeNode bulidTree(int [] arr,int index){
        if(index >=arr.length || arr[index] == -1)
            return null;
        TreeNode root = new TreeNode(arr[index]);
        root.leftnode = bulidTree(arr,index*2+1);
        root.rightnode = bulidTree(arr,index*2+2);
        return root;
    }
   
}
