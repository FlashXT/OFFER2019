package P03_Algorithm.A01_Recursion.A04_StringPatternMatching;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/2,16:07
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
class Node{
    int val;
    Node left;
    Node right;
    public Node(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
public class test {
    public static void main(String [] args){
        int [] arr = {1,2,3,4,5,6,7,8};
        Node root = BulidTree(arr,0);
        root = Tree(root);
        System.out.println();
    }
    public static Node BulidTree(int [] arr,int index){
        if(index >= arr.length || arr[index]==-1)
            return null;
        Node root = new Node(arr[index]);
        root.left = BulidTree(arr,index*2+1);
        root.right = BulidTree(arr,index*2+2);
        return root;
    }
    public static Node Tree(Node root){
        if(root == null || root.left==null&&root.right==null)
            return root;
        Node temp = root.left;
        root.left = Tree(root.right);
        root.right =Tree(temp);
        return root;
    }
}
