package P04_CodingInterviews.P045_LastRemaining;


import java.util.LinkedList;
import java.util.List;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/16,21:03
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method2 {
    public int LastRemaining(int n, int m) {
        if(n <= 0) return -1;
        List<Integer> list = new LinkedList<Integer>();
        for(int i = 0; i<n;i++){
            list.add(i);
        }
        int index = 0;
        while(list.size()!=1){

            index = (index+m-1)%list.size();
            int k = list.remove(index);
            //System.out.println(k);


        }
        return list.get(0);
    }
}
