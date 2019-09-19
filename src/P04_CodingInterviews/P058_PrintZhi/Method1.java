package P04_CodingInterviews.P058_PrintZhi;

import P04_CodingInterviews.HelpClass.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/19,17:59
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode tlast = pRoot,nlast = pRoot;
        queue.offer(pRoot);
        int level = 0;
        ArrayList<Integer> tres = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp.left!=null){
                nlast = temp.left;
                queue.offer(temp.left);
            }
            if(temp.right!=null){
                nlast = temp.right;
                queue.offer(temp.right);
            }
            if(level%2 ==0)
                tres.add(temp.val);
            else
                tres.add(0,temp.val);
            //System.out.print(temp.val+"\t");
            if(temp == tlast){
                level++;
                res.add(new ArrayList<>(tres));
                tres.clear();
                tlast = nlast;
            }
        }
        return res;
    }
}
