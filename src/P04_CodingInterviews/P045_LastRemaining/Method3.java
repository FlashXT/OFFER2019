package P04_CodingInterviews.P045_LastRemaining;


import java.util.LinkedList;
import java.util.List;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/16,21:03
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
//https://www.nowcoder.com/questionTerminal/11b018d042444d4d9ca4914c7b84a968
public class Method3 {
    public int LastRemaining(int n, int m) {
      if(n <1 || m <1)return -1;
      int last = 0;
      for(int i = 2; i <=n;i++){
          last = (last+m)%i;
      }
      return last;
    }
}
