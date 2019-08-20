package P04_CodingInterviews.CH8.Problem58_GetNextNode;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/5/16 19:56
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class GetNextNode {
    public static  void main(String [] args){

    }
    public static TreeLinkNode GetNextNode(TreeLinkNode node){
        //判断当前结点右子树是否为空
        if(node.right != null){
            //不空，则返回其右子树的最左结点
            TreeLinkNode right =  node.right;
            while( right!= null && right.left != null)
                right = right .left;
            return right;
        }
        //为空
        else{
            TreeLinkNode parent = node.next;
            //其父结点为空
            if(parent == null){
               return null;
            }
            //其父结点不空
            else{
                //当前结点是其父结点的左子树
                if(parent.left == node){
                    return parent;
                }
                //当前结点是其父结点的右子树
                else{

                    while(parent.next!=null){
                        if(parent.next.left == parent)
                            break;
                        parent = parent.next;
                    }
                    return parent.next;
                }
            }
        }
    }
}
