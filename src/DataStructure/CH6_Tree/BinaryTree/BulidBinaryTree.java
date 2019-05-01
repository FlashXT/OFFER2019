//package DataStructure.CH6_Tree.BinaryTree;
//
//import java.util.Arrays;
//
//public class BulidBinaryTree {
//    public static void main(String [] args){
//        int [] pre = {1,2,4,7,3,5,6,8};
//        int [] mid = {4,7,2,1,5,3,8,6};
//        int [] res = new int [pre.length];
//        int [] tree = BulidBinaryTree(pre,mid,0,pre.length-1,0,mid.length-1,res);
//        System.out.println(Arrays.toString(tree));
//
//    }
//    public static int [] BulidBinaryTree(int[] pre,int [] mid,int ps,int pe,int ms,int me,int[] res){
//
//       if(ps == pe || ms == me)
//                return res;
//       int i = ps;
//       for(i = ps; i<= pe;i++)
//           if(pre[ps] == mid[i]){
//               res
//           }
//               break;
//       BulidBinaryTree(pre,mid,begin+1,i-1);
//       BulidBinaryTree(pre,mid,i+1,end);
//
//
//
//        return pre;
//
//    }
//}
