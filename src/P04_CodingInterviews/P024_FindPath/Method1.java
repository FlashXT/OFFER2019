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
public class Method1 {

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

        if(root == null ) return ;
        if(root.left == null && root.right == null){
            if(target == 0){
                path.add(root.val);
                paths.add(new ArrayList<>(path));
                path.remove((Integer)root.val);
            }
            return ;
        }
        path.add(root.val);
        FindPath(root.left,target- root.val,path,paths);
        FindPath(root.right,target-root.val,path,paths);
        path.remove((Integer) root.val);
    }
}
