package CH5_Tree;

import java.util.Stack;

/****************************************************************************
 * 二叉树的遍历方法二：从二叉树的根结点开始遍历，然后再回到根结点，会经过每个结点3次，那么：
 *  先序遍历：在第1次经过该结点时输出该结点；
 *  中序遍历：在第2次经过该结点时输出该结点；
 *  后序遍历：在第3次经过该结点时输出该结点；
 *此方法比较麻烦，需要对二叉树中的结点进行二次封装（附加统计经过次数的变量），仅用来理论验证；
 * ***************************************************************************/
public class treeTraverse2 {
    class  traNode<T>{
        T item;
        int time = 0;
        public traNode(){}
        public traNode(T item,int time){
            this.item = item;
            this.time = time;
        }
        public traNode(int time){
            this.time = time;
        }
    }
    public static void main(String [] args){
        Integer [] arr = {1,2,3,4,5,6,7};
        BinaryTree<Integer> tree = new BinaryTree<>(arr);
        treeTraverse2 tra = new treeTraverse2();
        tra.preTraverse(tree.root);
        tra.midTraverse(tree.root);
        tra.posTraverse(tree.root);

    }

    public  void preTraverse(TreeNode<Integer> node){
        Stack<traNode> stack = new Stack<>();
        traNode <TreeNode> tnode  = new traNode<>(node,0);
        while(tnode.item != null || !stack.isEmpty()){
            if( tnode.item != null){
                tnode = new traNode<>(tnode.item,tnode.time+1);
                if(tnode.time == 1)
                    System.out.printf("%2d\t",tnode.item.item);
                stack.push(tnode);
                tnode = new traNode<>(tnode.item.leftnode,0);
            }
            else{

                tnode = stack.pop();

                if(tnode.time+1 < 3){
                    stack.push(new traNode(tnode,tnode.time+1));

                    tnode = new traNode<>(tnode.item.rightnode,0);
                }
                else{
                    tnode = new traNode<>(null,0);
                }

            }

        }
        System.out.println();

    }
    public  void midTraverse(TreeNode<Integer> node){
        Stack<traNode> stack = new Stack<>();
        traNode <TreeNode> tnode  = new traNode<>(node,0);
        while(tnode.item != null || !stack.isEmpty()){
            if( tnode.item != null){
                tnode = new traNode<>(tnode.item,tnode.time+1);

                stack.push(tnode);
                tnode = new traNode<>(tnode.item.leftnode,0);
            }
            else{

                tnode = stack.pop();

                if(tnode.time+1 < 3){
                    stack.push(new traNode(tnode,tnode.time+1));
                    if(tnode.time+1 ==2)
                        System.out.printf("%2d\t",tnode.item.item);
                    tnode = new traNode<>(tnode.item.rightnode,0);
                }
                else{
                    tnode = new traNode<>(null,0);
                }

            }

        }
        System.out.println();

    }
    public  void posTraverse(TreeNode<Integer> node){
        Stack<traNode> stack = new Stack<>();
        traNode <TreeNode> tnode  = new traNode<>(node,0);
        while(tnode.item != null || !stack.isEmpty()){
            if( tnode.item != null){
                tnode = new traNode<>(tnode.item,tnode.time+1);

                stack.push(tnode);
                tnode = new traNode<>(tnode.item.leftnode,0);
            }
            else {

                tnode = stack.pop();
                if (tnode.time + 1 < 3) {
                    stack.push(new traNode(tnode.item, tnode.time + 1));

                    tnode = new traNode<>(tnode.item.rightnode, 0);
                }
//                else{
                if (tnode.time + 1 == 3) {
                    System.out.printf("%2d\t", tnode.item.item);

                    tnode = new traNode<>(null, 0);
                }


            }
        }
        System.out.println();

    }
}
