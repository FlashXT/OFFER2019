package P04_CodingInterviews.OldVersion.CH2;

import P01_DataStructure.CH3_StackQueue.ArrayStack;

class Node{
    int value;
    Node leftnode;
    Node rightnode;
    public Node(int val){
        this.value = val;
        leftnode = null;
        rightnode = null;
    }
}
public class BulidBinaryTree {
    public static void main(String [] args){

        int [] pre = {1,2,4,7,3,5,6,8};
        int [] ino = {4,7,2,1,5,3,8,6};
        Node root = Construct(pre,ino);
        preTraverse(root);
        System.out.println();
    }
    public static Node Construct(int [] preorder,int [] inorder){
        if(preorder == null ||inorder == null){
            return null;
        }
        return ConstructCore(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    public static Node ConstructCore(int [] preprder,int pstart ,int pend,int [] inorder,int istart,int iend){
        //先序遍历序列的第一个数字是根结点的值
        if(pstart > pend || istart > iend)
            return null;
        Node root = new Node(preprder[pstart]);
        int i = istart;
        //在中序遍历中找到根结点的值
        while( i <= iend && inorder[i] != root.value ){
            i++;
        }
        int leftlength = i - istart;
        int leftPreend = pstart + leftlength;
        if(i-istart > 0){
           root.leftnode = ConstructCore(preprder,pstart+1,leftPreend,inorder,istart,i-1);
        }
        if(i - istart < pend-pstart){
            root.rightnode = ConstructCore(preprder,leftPreend+1,pend,inorder,i+1,iend);
        }
        return root;
    }

    //先序遍历非递归
    public static void preTraverse(Node node){
        if(node!=null){
            ArrayStack<Node> stack = new ArrayStack<>();
            stack.push(node);
            while (!stack.isEmpty()){
                node = stack.pop();
                System.out.printf("%2d\t",node.value);
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
}
