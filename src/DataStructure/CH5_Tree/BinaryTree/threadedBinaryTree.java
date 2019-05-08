package DataStructure.CH5_Tree.BinaryTree;

public class threadedBinaryTree {
    static class tNode{
        //结点的值
        int value;
        //左右孩子
        tNode lchild,rchild;
        //线索标志
        boolean Ltag,Rtag;
        public tNode(int value){
            this.value = value;
            this.lchild=null;
            this.rchild=null;
            this.Ltag=false;
            this.Rtag=false;
        }
    }
    private static  tNode preNode;
    public static void main(String [] args){
        int[] arr={1,2,3,4,-1,5,6};
        tNode root = bulidTree(arr,0);
        System.out.println("中序遍历二叉树：");
        traverse(root);
        //中序线索化二叉树
        tNode thrt = threadTree(root);

        //中序遍历线索化二叉树
        traverseThreadTree(thrt);
        traverseThreadTree2(thrt);
    }
    public static tNode bulidTree(int[]arr,int i){
        if(i >=arr.length) return null;
        if(arr[i] == -1) return null;
        tNode node = new tNode(arr[i]);
        node.lchild = bulidTree(arr,i*2+1);
        node.rchild = bulidTree(arr,i*2+2);
        return node;
    }
    public static void traverse(tNode node){
        if(node!=null){
            traverse(node.lchild);
            System.out.printf("%-4d",node.value);

            traverse(node.rchild);
        }
    }
    //中序线索化二叉树
    public static tNode threadTree(tNode root){
        tNode Thrt = new tNode(-1);
        Thrt.Ltag = false;
        Thrt.Rtag = true; Thrt.rchild = Thrt;
        if(root == null) Thrt.lchild = Thrt;
        else{
            Thrt.lchild = root;
            preNode = Thrt;
            InThreading(root);
            preNode.rchild = Thrt;
            preNode.Rtag = true;
            Thrt.rchild = preNode ;
        }
        return Thrt;
    }
    public static void InThreading(tNode node){
        if(node!=null){
            InThreading(node.lchild);   //左子树线索化

            if(node.lchild==null){
                node.Ltag = true;
                node.lchild = preNode;
            }
            if(preNode.rchild==null){
                preNode.Rtag = true;
                preNode.rchild = node;
            }
            preNode = node;

            InThreading(node.rchild);   //右子树线索化
        }
    }


    //中序遍历后继线索化二叉树
    public static void  traverseThreadTree(tNode node){
        System.out.println("\n中序后继遍历线索化二叉树：");
        tNode  p = node.lchild;
        while(p!=node){
            while(p.Ltag == false)
                p = p.lchild;
            System.out.printf("%-4d",p.value);
            while(p.Rtag == true && p.rchild != node){
                p = p.rchild;
                System.out.printf("%-4d",p.value);
            }
            p = p.rchild;
        }
        System.out.println();
    }
    //中序前驱遍历线索化二叉树
    public static void  traverseThreadTree2(tNode node){
        System.out.println("中序前驱遍历线索化二叉树：");
        tNode  p = node.rchild;
        while(p!=node){
            while(p.Ltag == true && p!=node){
                System.out.printf("%-4d",p.value);
                p = p.lchild;
            }
            if(p!=node){
                System.out.printf("%-4d",p.value);
                p = p.lchild;
            }

        }
        System.out.println();
    }


}
