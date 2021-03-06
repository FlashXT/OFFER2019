package P04_CodingInterviews.OldVersion.CH4.AbstractConcrete;
import P04_CodingInterviews.HelpClass.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/10 7:58;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Problem25_SumPath{

    public static void main(String [] args){
        int [] arr = {5,4,-1,3,-1,-1,-1,2,-1,-1,-1,-1,-1,-1,-1,1};
        TreeNode root = BulidTree(arr,0);
        preTraverse(root);
//        System.out.println();
//        ArrayList<ArrayList<Integer>> paths = FindPath(root,15);
//
//
//        System.out.println(Arrays.toString(paths.toArray()));


    }
        public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
            ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
            ArrayList<Integer> path = new ArrayList<>();
            SumPath(root,target,path,paths);
            Collections.sort(paths, new Comparator<ArrayList<Integer>>() {
                @Override
                public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {

                    if(o1.size() < o2.size())
                        return 1;
                    else if (o1.size() == o2.size())
                        return 0;
                    else
                        return -1;
                }
            });
            return paths;

        }
        public static void SumPath(TreeNode root, int sum, ArrayList<Integer> path,ArrayList<ArrayList<Integer>> paths){
            if(root == null) {
                return ;
            }
            if(root.left == null && root.right== null){
                if(sum == root.val){
                    path.add(root.val);
                    paths.add(new ArrayList<Integer>(path));
                    path.remove((Integer)root.val);
                }
                return ;
            }

            path.add(root.val);
            SumPath(root.left, sum - root.val,path,paths);
            SumPath(root.right,sum - root.val,path,paths);
            path.remove((Integer)root.val);

        }
        public static TreeNode BulidTree(int [] arr,int index){
            if(index >= arr.length || arr[index]== -1)
                return null;

            TreeNode root = new TreeNode(arr[index]);
            root.left = BulidTree(arr,2*index+1);
            root.right = BulidTree(arr,2*index+2);
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
