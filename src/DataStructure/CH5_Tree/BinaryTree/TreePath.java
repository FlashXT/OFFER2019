package DataStructure.CH5_Tree.BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/5/19 10:13
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class TreePath {

    public static void main(String [] args){
        Integer [] arr = {1,2,3,4,5};
        BinaryTree<Integer> tree = new BinaryTree<Integer>(arr);
        ArrayList<String> res = new ArrayList<>();

        res = path(tree.root,"",res);
        System.out.println(Arrays.toString(res.toArray()));

    }
    public static ArrayList<String> path(TreeNode<Integer> root,String str,ArrayList<String> res){
        if(root == null){
            return res;
        }
        if(root.leftnode ==null && root.rightnode == null){
            str +=root.item;
            String temp="";
            for(int i = 0; i < str.length()-1;i++)
                temp+=str.charAt(i)+"->";
            temp+=str.charAt(str.length()-1);
            res.add(temp);

            return null;
        }
        str +=root.item;
        path(root.leftnode,str,res);
        path(root.rightnode,str,res);
        return res;
    }
}
