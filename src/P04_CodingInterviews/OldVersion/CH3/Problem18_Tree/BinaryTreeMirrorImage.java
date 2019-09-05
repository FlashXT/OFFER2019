package P04_CodingInterviews.OldVersion.CH3.Problem18_Tree;

import java.util.Stack;

/*********************************************
 * 生成原二叉树的镜像
 *********************************************/
public class BinaryTreeMirrorImage {

    public static void main(String [] main){
        int [] arr = {1,2,3,4,5,6,7,8};

        TreeNode tree = BulidTree(arr,0);
        preTraverse(tree);
        System.out.println();
        midTraverse(tree);
        System.out.println();
        tree = TreeMirrorImage(tree);
        preTraverse(tree);
        System.out.println();
        midTraverse(tree);
        System.out.println();
        TreeNode tree2 =TreeMirrorImage2(tree);
        preTraverse(tree2);
        System.out.println();
        midTraverse(tree2);

    }

    //递归
    public static TreeNode TreeMirrorImage(TreeNode root){

        if(root == null) return null;
        TreeNode temp = root.leftNode;
        root.leftNode = TreeMirrorImage(root.rightNode);
        root.rightNode = TreeMirrorImage(temp);
        return root;
    }

    //非递归:从递归版的思路出发，可以发现只要采取某一种遍历方式去遍历树的所有的
    //非叶子节点，然后交换它的左右子树，当遍历结束，即可得到二叉树的镜像。使用某
    //种非递归的遍历方法，将打印元素操作改为交换该结点的左右子树即可。
    public static TreeNode TreeMirrorImage2(TreeNode root){
        TreeNode temp = root;
        Stack<TreeNode> stack = new Stack<>();

        while(!stack.isEmpty() || temp!=null){
            if(temp!= null){
                TreeNode node = temp.leftNode;
                temp.leftNode =  temp.rightNode;
                temp.rightNode = node;
                stack.push(temp);
                temp = temp.leftNode;
            }
            else{
                temp = stack.pop();
                temp = temp.rightNode;
            }
        }
        return root;
    }
    public static TreeNode BulidTree(int [] arr,int index){
        if(index >= arr.length || arr[index]==-1) return null;
        TreeNode root = new TreeNode(arr[index]);
        root.leftNode = BulidTree(arr,index*2+1);
        root.rightNode = BulidTree(arr,index*2+2);
        return root;
    }
    public static void preTraverse(TreeNode root){
        if(root == null) return;
        System.out.printf("%d\t",root.value);
        preTraverse(root.leftNode);
        preTraverse(root.rightNode);

    }
    public static void midTraverse(TreeNode root){
        if(root == null) return;
        midTraverse(root.leftNode);
        System.out.printf("%d\t",root.value);
        midTraverse(root.rightNode);

    }

}
