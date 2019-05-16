package TencentOffer.CH8.Problem62_SerializeTree;

import sun.reflect.generics.tree.Tree;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/5/16 21:22
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class SerializeTree {
    static int index = -1;
    public static  void main(String [] args){
        int [] arr = {1,2,3,4,-1,5,6};
        TreeNode root = BulidTree(arr,0);
        String str = Serialize(root);
        System.out.println(str);

        TreeNode root2 = DSerialize(str);
        preTraverse(root2);


    }
    public static String Serialize(TreeNode root){
        if(root == null)
            return "#,";
        return root.val+","+Serialize(root.left)+Serialize(root.right);
    }

    public static TreeNode DSerialize(String str){
        index++;
        String [] strr = str.split(",");
        if(index >= str.length()|| strr[index].equals("#"))
            return null;
        TreeNode root = new TreeNode(Integer.valueOf(strr[index]));
        root.left = DSerialize(str);
        root.right = DSerialize(str);
        return root;
    }
    public static  TreeNode BulidTree(int [] arr,int index){
        if(index >= arr.length || arr[index]==-1)
            return null;
        TreeNode root = new TreeNode(arr[index]);
        root.left = BulidTree(arr,index*2+1);
        root.right = BulidTree(arr,index*2+2);
        return root;

    }
    public static void preTraverse(TreeNode root){
        if(root != null){
            System.out.printf("%d\t",root.val);
            preTraverse(root.left);
            preTraverse(root.right);
        }
    }
}
