package P04_CodingInterviews.P023_VerifySquenceOfBST;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/8 21:52
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0) return false;
        return VerifySquenceOfBST(sequence,0,sequence.length-1);
    }
    private boolean VerifySquenceOfBST(int [] sequence,int start,int end) {
        if(start > end) return true;
        int pivot =start;
        while(pivot<end && sequence[pivot] < sequence[end]){
            pivot++;
        }
        int index = pivot;
        while(index < end ){
            if(sequence[index] < sequence[end])
                return false;
            index++;
        }
        return VerifySquenceOfBST(sequence,start,pivot-1)&&
                VerifySquenceOfBST(sequence,pivot,end-1);
    }
}
