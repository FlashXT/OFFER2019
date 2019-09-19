package P04_CodingInterviews.P057_isSymmetrical;

import P04_CodingInterviews.HelpClass.Tree;
import P05_CodeExam.JD.Test;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/19 16:44
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Main {
    public static  void main(String [] args){
        int [ ] nums = {8,6,6,5,7,7,5};
        Tree tree = new Tree(nums);
        boolean res = new Method1().isSymmetrical(tree.root);
        System.out.println(res);
    }
}
