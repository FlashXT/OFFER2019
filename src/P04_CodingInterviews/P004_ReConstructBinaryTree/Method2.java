package P04_CodingInterviews.P004_ReConstructBinaryTree;

import P01_DataStructure.CH3_StackQueue.ArrayStack;
import P04_CodingInterviews.HelpClass.TreeNode;

public class Method2 {
    public static void main(String [] args){

        int [] pre = {1,2,4,7,3,5,6,8};
        int [] ino = {4,7,2,1,5,3,8,6};
        TreeNode root = Construct(pre,ino);
        preTraverse(root);
        System.out.println();
    }
    public static TreeNode Construct(int [] preorder,int [] inorder){
        if(preorder == null ||inorder == null){
            return null;
        }
        return ConstructCore(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    public static TreeNode ConstructCore(int [] preprder,int pstart ,int pend,int [] inorder,int istart,int iend){
        //先序遍历序列的第一个数字是根结点的值
        if(pstart > pend || istart > iend)
            return null;
        TreeNode root = new TreeNode(preprder[pstart]);
        int i = istart;
        //在中序遍历中找到根结点的值
        while( i <= iend && inorder[i] != root.val ){
            i++;
        }
        int leftlength = i - istart;
        int leftPreend = pstart + leftlength;
        if(i-istart > 0){
           root.left = ConstructCore(preprder,pstart+1,leftPreend,inorder,istart,i-1);
        }
        if(i - istart < pend-pstart){
            root.right = ConstructCore(preprder,leftPreend+1,pend,inorder,i+1,iend);
        }
        return root;
    }

    //先序遍历非递归
    public static void preTraverse(TreeNode TreeNode){
        if(TreeNode!=null){
            ArrayStack<TreeNode> stack = new ArrayStack<>();
            stack.push(TreeNode);
            while (!stack.isEmpty()){
                TreeNode = stack.pop();
                System.out.printf("%2d\t",TreeNode.val);
                //压栈时先压入右孩子，再压入左孩子，
                // 出栈时先出左孩子，再出右孩子
                if(TreeNode.right != null){
                    stack.push(TreeNode.right);
                }
                if(TreeNode.left != null){
                    stack.push(TreeNode.left);
                }
            }
        }
        System.out.println();
    }
}
