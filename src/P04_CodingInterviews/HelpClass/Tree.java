package P04_CodingInterviews.HelpClass;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/8,9:52
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Tree {
    public TreeNode root;
    public Tree(int [] arr){
       root= BulidTree(arr,0);
    }
    private TreeNode BulidTree(int [] arr,int index){
        if(index >= arr.length || arr[index]==-1)
            return null;
        TreeNode root = new TreeNode(arr[index]);
        root.left = BulidTree(arr,index*2+1);
        root.right = BulidTree(arr,index*2+2);
        return root;
    }
    public void preTraversal(){
        preTrave(this.root);
    }
    private void preTrave(TreeNode root){
        if(root == null) return ;
        System.out.print(root.val+" ");
        preTrave(root.left);
        preTrave(root.right);
    }
    public void inTraversal(){
        inTraversal(this.root);
    }
    private void inTraversal(TreeNode root){
        if(root == null) return ;

        inTraversal(root.left);
        System.out.print(root.val+" ");
        inTraversal(root.right);
    }
}
