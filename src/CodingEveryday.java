import P02_JAVA.Collection.C02_Stack_Queue.TestStack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/8/23,14:41
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
class Node{
    int val;
    Node left;
    Node right;
    public Node(){}
    public Node(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
public class CodingEveryday {
    public static void main(String [] args){
        //建立二叉树
        int [] arr = {1,2,3,4,5,-1,-1,6,-1,-1,-1};
        Node root = BulidTree(arr,0);
        posTraverse2(root);
//        levelTraverse2(root);
    }
    public static Node BulidTree(int [] nums,int index){
        if(index >= nums.length ||nums[index] == -1)
            return null;
        Node root = new Node(nums[index]);
        root.left = BulidTree(nums,index*2+1);
        root.right = BulidTree(nums,index*2+2);
        return root;
    }
    public static void preTraverseR(Node root){
        if(root == null) return ;
        System.out.println(root.val);
        preTraverseR(root.left);
        preTraverseR(root.right);
    }
    public static void preTraverse(Node root){
        Stack<Node> stack = new Stack<>();
        Node temp = root;
        while(temp != null || !stack.isEmpty()){

            if(temp!=null){
                System.out.print(temp.val+"\t");
                stack.push(temp);
                temp = temp.left;
            }
            else{
                temp = stack.pop();
                temp = temp.right;
            }
        }
        System.out.println();
    }
    public static void midTraverse(Node root){
        Stack<Node> stack = new Stack<>();
        Node temp = root;
        while(temp != null || !stack.isEmpty()){
            if(temp!= null){
             stack.push(temp);
             temp = temp .left;
            }
            else{
             temp = stack.pop();
             System.out.print(temp.val+"\t");
             temp = temp.right;
            }
        }
        System.out.println();
    }

    public static void posTraverse(Node root){
        Stack<Node> stack = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        Node temp = root;
        stack.push(root);
        if(temp != null){
            while( !stack.isEmpty()) {
                temp = stack.pop();
                stack2.push(temp);
                if (temp.left != null)
                    stack.push(temp.left);
                if (temp.right != null)
                    stack.push(temp.right);
            }
        }
        while(!stack2.isEmpty())
            System.out.print(stack2.pop().val+"\t");
        System.out.println();
    }
    public static void posTraverse2(Node root){
        Stack<Node> stack = new Stack<>();
        //c指向栈顶元素，h指向刚打印过的元素
        Node h = root,c=null;
        if(root!=null){
            stack.push(h);
            while(!stack.isEmpty()){
                c = stack.peek();
                if(c.left!= null && c.left!=h && c.right!=h){
                    stack.push(c.left);
                }
                else if(c.right!=null && c.right!=h){
                    stack.push(c.right);
                }else{
                    c = stack.pop();
                    h=c;
                    System.out.print(h.val+"\t");
                }
            }
        }
        stack.push(h);
        Node temp = root;

        System.out.println();
    }

    public static void levelTraverse(Node root){
        Queue<Node> queue = new LinkedList<>();
        Node temp;
        queue.offer(root);
        while( !queue.isEmpty()){
            temp = queue.remove();
            if(temp.left!= null)
                queue.offer(temp.left);
            if(temp.right!=null)
                queue.offer(temp.right);
            System.out.print(temp.val+"\t");
        }
        System.out.println();
    }
    public static void levelTraverse2(Node root){
        Queue<Node> queue = new LinkedList<>();
        Node temp,olast=root,nlast=root;
        queue.offer(root);
        int level = 0;
        System.out.print("Level "+level+++":");
        while( !queue.isEmpty()){
            temp = queue.remove();

            if(temp.left!= null){
                queue.offer(temp.left);
                nlast = temp.left;
            }

            if(temp.right!=null){
                queue.offer(temp.right);
                nlast = temp.right;
            }

            System.out.print(temp.val+"\t");
            if(temp == olast && !queue.isEmpty()){
                System.out.print("\nLevel "+level+++":");
                olast = nlast;
            }

        }

    }
}
