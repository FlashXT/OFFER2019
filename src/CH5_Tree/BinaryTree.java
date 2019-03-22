package CH5_Tree;

import CH5_Tree.TreeNode;
public class BinaryTree <Item>{

    TreeNode<Item> root = null;
    public  BinaryTree(){ }
    public  BinaryTree(Item [] arr){
        this.root = create(arr,0);
    }

    /***********************************************************
    * 递归建立二叉树的过程：
    * ①沿着一个结点的左子树建立，直到该结点的左子树为空，
    * ②退出该次递归；
    * ③然后建立该结点的右子树；
    * 如此递归建立二叉树；
    * **********************************************************/
    public TreeNode create(Item[] item,int i){
        if(i >= item.length){
            return null;
        }
        if(item[i].equals(-1)){      //用-1区分没有子结点的情况
            return null;
        }
        else{
            TreeNode node = new TreeNode(item[i]);
            //建立该结点的左子树
            node.leftnode = create(item, 2 * i + 1);
            //建立该结点的右子树
            node.rightnode = create(item, 2 * i + 2);
            return node;
        }
    }
    //先序遍历
    public void preTraverse(){
        preTraverse(root);
        System.out.println();
    }
    public void preTraverse(TreeNode node){
        if(node == null)
            return ;
        System.out.printf("%d\t",node.item);
        preTraverse(node.leftnode);
        preTraverse(node.rightnode);

    }
    //中序遍历
    public void midTraverse(){
        midTraverse(root);
        System.out.println();
    }
    public void midTraverse(TreeNode node){
        if(node == null)
            return ;

        midTraverse(node.leftnode);
        System.out.printf("%d\t",node.item);
        midTraverse(node.rightnode);

    }
    //后序遍历
    public void posTraverse(){
        posTraverse(root);
        System.out.println();
    }
    public void posTraverse(TreeNode node){
        if(node == null)
            return ;

        posTraverse(node.leftnode);
        posTraverse(node.rightnode);
        System.out.printf("%d\t",node.item);

    }

}
