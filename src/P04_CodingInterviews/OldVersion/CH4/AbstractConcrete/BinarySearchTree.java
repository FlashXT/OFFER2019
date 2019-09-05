package P04_CodingInterviews.OldVersion.CH4.AbstractConcrete;

/**
 * @Author: turboman
 * @Date: 2019/5/8 21:34
 * @Version 1.0
 */
public class BinarySearchTree {
    public static void main(String [] args){
        int [] arr = {5,7,6,9,8,10,8};
        System.out.println(VerifySquenceOfBST(arr));
    }
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0) return false;
        return VerifySquence(sequence,0,sequence.length-1);
    }
    public static boolean VerifySquence(int [] arr,int start,int end){
        if(start > end ) return true;
        int i = start;
        //左子树中的值都小于根结点的值
        for(; i<= end-1;i++){
            if(arr[i] > arr[end]){
                break;
            }
        }
        //右子树中的值都大于根结点的值
        for(int j = i; j<= end-1;j++){
            if(arr[j] < arr[end]){
                return false;
            }
        }
        return VerifySquence(arr,start,i-1)&&VerifySquence(arr,i,end-1);

    }
}
