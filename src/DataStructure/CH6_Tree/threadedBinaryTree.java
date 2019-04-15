package DataStructure.CH6_Tree;

class threadNode{
    //结点的值
    int value;
    //左右孩子
    threadNode lchild,rchild;
    //线索标志
    boolean Ltag,Rtag;
    public threadNode(int value){
        this.value = value;
        this.lchild=null;
        this.rchild=null;
        this.Ltag=false;
        this.Rtag=false;
    }
}
public class threadedBinaryTree {
    public static void main(String [] args){
        int[] arr={1,2,3,4,-1,5,6};
        threadNode root = bulidTree(arr,0);
        traverse(root);

    }
    public static threadNode bulidTree(int[]arr,int i){
        if(i >=arr.length) return null;
        if(arr[i] == -1) return null;
        threadNode node = new threadNode(arr[i]);
        node.lchild = bulidTree(arr,i*2+1);
        node.rchild = bulidTree(arr,i*2+2);
        return node;
    }
    public static void traverse(threadNode node){
        if(node!=null){
            System.out.printf("%-4d",node.value);
            traverse(node.lchild);
            traverse(node.rchild);
        }
    }
//    public static threadNode threadTree(threadNode root){
//        threadNode Thrt = new threadNode(-1);
//        Thrt.Ltag = false;
//        Thrt.Rtag = true; Thrt.rchild = Thrt;
//        if(root == null) Thrt.lchild = Thrt;
//        else{
//            Thrt.lchild = root;
//            threadNode pre = root;
//            InThreading(root);
//        }
//
//    }
//
//    public static void InThreading(threadNode node){
//
//    }
}
