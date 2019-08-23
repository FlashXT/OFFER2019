package P01_DataStructure.CH5_Tree.BinaryTree;
//二叉树的非递归遍历
import P01_DataStructure.CH3_StackQueue.ArrayStack;

import java.util.Stack;

public class treeTraverse1 {
    public static void main(String [] args){
        Integer [] arr = {1,2,3,4,5,6,7};
        BinaryTree<Integer> tree = new BinaryTree<Integer>(arr);
//        preTraverse3(tree.root);
//        midTraverse(tree.root);
            posTraverse(tree.root);
    }
    //先序遍历非递归1
    public static void preTraverse(TreeNode<Integer>  node){
        if(node!=null){
            ArrayStack<TreeNode> stack = new ArrayStack<>();
            stack.push(node);
            while (!stack.isEmpty()){
                node = stack.pop();
                System.out.printf("%2d\t",node.item);
                //压栈时先压入右孩子，再压入左孩子，
                // 出栈时先出左孩子，再出右孩子
                if(node.rightnode != null){
                    stack.push(node.rightnode);
                }
                if(node.leftnode != null){
                    stack.push(node.leftnode);
                }
            }
        }
        System.out.println();
    }
    //先序遍历非递归2
    public static void preTraverse1(TreeNode<Integer>  node){
        if(node == null) return ;
        ArrayStack<TreeNode> stack = new ArrayStack<>();
        stack.push(node);
        TreeNode temp ;
        while(!stack.isEmpty()){
            temp = stack.peek();
            while( temp != null){
                System.out.printf("%2d\t",temp.item);
                //temp 不空，就压入temp的左孩子，此种方式会向栈中压入空元素，效率较低
                stack.push(temp.leftnode);
                temp = temp.leftnode;
            }
            stack.pop();
            if(!stack.isEmpty()){
                temp = stack.pop();
                stack.push(temp.rightnode);
            }
        }
        System.out.println();
    }
    //先序遍历非递归3
    public static void preTraverse2(TreeNode<Integer>  node){
        if(node == null) return ;
        ArrayStack<TreeNode> stack = new ArrayStack<>();
        TreeNode temp = node;
        while(!stack.isEmpty() || temp != null){
            //沿着某一结点的左孩子一直遍历，直到某一结点没有左孩子
            while( temp!= null){
                System.out.printf("%2d\t",temp.item);
                stack.push(temp);
                temp = temp.leftnode;
            }
            //temp 为空，表示当前栈顶元素的左孩子为空，转向该结点的右孩子
            if(!stack.isEmpty()){
                //弹出此时的栈顶元素
                temp = stack.pop();
                //转向改元素的右孩子，但并不压栈！！！
                // 压栈在上面的循环中完成
                temp = temp.rightnode;
            }
        }
        System.out.println();
    }
    //先序遍历非递归4
    public static void preTraverse3(TreeNode<Integer>  node){
        if(node == null) return ;
        ArrayStack<TreeNode> stack = new ArrayStack<>();
        TreeNode temp = node;
        // if用来压栈，else用来转向，逻辑清晰
        while(!stack.isEmpty() || temp != null){
            //temp 不空，将该结点入栈，沿着该结点的左孩子压栈
            if( temp!= null){
                System.out.printf("%2d\t",temp.item);
                stack.push(temp);
                temp = temp.leftnode;
            }
            //如果temp为空，转向
            else{
                //弹出此时的栈顶元素
                temp = stack.pop();
                //转向该元素的右孩子，但并不压栈！！！
                // 压栈在上面的循环中完成
                temp = temp.rightnode;
            }
        }
        System.out.println();
    }

    //中序遍历非递归1
    public static void midTraverse(TreeNode<Integer>  node){
        if(node == null) return ;
        ArrayStack<TreeNode> stack = new ArrayStack<>();

        TreeNode temp = node ;
        while(!stack.isEmpty()|| temp != null){
            while( temp != null){
                stack.push(temp);
                temp = temp.leftnode;
            }
            if(!stack.isEmpty()){
                temp = stack.pop();
                System.out.printf("%2d\t",temp.item);
                temp = temp.rightnode;
            }
        }
        System.out.println();
    }
    //中序遍历非递归2
    public static void midTraverse1(TreeNode<Integer>  node){

        ArrayStack<TreeNode> stack = new ArrayStack<>();
        TreeNode ptr = node;
        while(ptr!= null || !stack.isEmpty()){
            //if控制 沿着 该结点的左孩子一直压栈，直到为空
            if(ptr != null){
                stack.push(ptr);
                ptr = ptr.leftnode;
            }
            //若该结点的左孩子为空，转向该结点的右孩子
            else{
                ptr = stack.pop();
                System.out.printf("%2d\t",ptr.item);
                ptr = ptr.rightnode;
            }
        }
        System.out.println();

    }

    //后序遍历非递归双栈法
    public static void posTraverse(TreeNode<Integer>  node){
        ArrayStack<TreeNode> stack = new ArrayStack<>();
        //辅助栈，从栈stack中出栈的结点按顺序保存到stack2中
        ArrayStack<TreeNode> stack2 = new ArrayStack<>();

        TreeNode temp = node;
        stack.push(temp);
        if(temp != null){
            while(!stack.isEmpty()){
                temp = stack.pop();
                //stack2中按stack出栈的元素的顺序压入元素(中右左)
                stack2.push(temp);
                //stack栈中，先压入自身，再压入左孩子，最后压入右孩子
                if(temp.leftnode != null){
                    stack.push(temp.leftnode);
                }
                if(temp.rightnode != null){
                    stack.push(temp.rightnode);
                }
            }
            //将stack2的元素出栈输出（左右中）
            while(!stack2.isEmpty()){
                System.out.printf("%-2d\t",stack2.pop().item);
            }
            System.out.println();
        }
    }
    public static void posTraverse2(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        //c指向栈顶元素，h指向刚打印过的元素
        TreeNode h = root,c=null;
        if(root!=null){
            stack.push(h);
            while(!stack.isEmpty()){
                c = stack.peek();
                if(c.leftnode!= null && c.leftnode!=h && c.rightnode!=h){
                    stack.push(c.leftnode);
                }
                else if(c.rightnode!=null && c.rightnode!=h){
                    stack.push(c.rightnode);
                }else{
                    c = stack.pop();
                    h=c;
                    System.out.print(h.item+"\t");
                }
            }
        }
        stack.push(h);
        TreeNode temp = root;

        System.out.println();
    }
}
