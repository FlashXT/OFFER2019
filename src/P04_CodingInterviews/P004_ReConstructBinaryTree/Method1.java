package P04_CodingInterviews.P004_ReConstructBinaryTree;

import P04_CodingInterviews.HelpClass.TreeNode;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/5 15:34
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {

        return reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);

    }
    private TreeNode reConstructBinaryTree(int [] pre,int ps,int pe, int [] in,int is,int ie) {
        if(ps > pe || is > ie)
            return null;
        if(ps == pe && is == ie){
            return new TreeNode(pre[ps]);
        }
        TreeNode root = new TreeNode(pre[ps]);
        int iroot = is;
        while(iroot <= ie){
            if(in[iroot] == pre[ps]){
                break;
            }
            iroot++;
        }
        //左子树的长度
        int leftlength = iroot - is;
        //先序序列种左子树的结尾下标
        int leftPreend = ps + leftlength;
        if( leftlength > 0)
            root.left = reConstructBinaryTree(pre,ps+1,leftPreend,in,is,iroot-1);
        if(leftlength < pe - ps)
            root.right = reConstructBinaryTree(pre,leftPreend+1,pe,in,iroot+1,ie);
        return root;
    }
}
