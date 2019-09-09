package P04_CodingInterviews.P024_FindPath;

import P04_CodingInterviews.HelpClass.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/8 22:19
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method2 {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        if(root == null) return paths;
        ArrayList<Integer> path = new ArrayList<>();

        FindPath(root,target,path,paths);
        Collections.sort(paths, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {

               return o2.size() - o1.size();
            }
        });
        return paths;
    }
    public void FindPath(TreeNode root, int target,ArrayList<Integer> path,ArrayList<ArrayList<Integer>> paths) {
        target -= root.val;
        path.add(root.val);
        if(root.left == null && root.right == null && target == 0){
            paths.add(new ArrayList<>(path));
        }
        if(root.left != null)
            FindPath(root.left,target,path,paths);
        if(root.right != null)
            FindPath(root.right,target,path,paths);

        path.remove((Integer) root.val);
    }
}
