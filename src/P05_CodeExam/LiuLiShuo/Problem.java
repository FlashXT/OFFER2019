package P05_CodeExam.LiuLiShuo;

import java.util.HashSet;
import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/8/19,18:59
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
//Leetcode36:有效的数独
public class Problem {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        char [][] board = new char[9][9];
        for(int i = 0; i < 9;i++){
            board[i] = scan.next().toCharArray();
        }
        System.out.println(isValid(board));

    }
    public static boolean isValid(char[][] board){
        HashSet [] row = new HashSet[9];
        HashSet [] col = new HashSet[9];
        HashSet [] cell = new HashSet[9];
        for(int m = 0; m < 9;m++){
            row[m] = new HashSet<Character>();
            col[m] = new HashSet<Character>();
            cell[m] = new HashSet<Character>();
        }
        for(int i = 0;i < 9;i++){
            for(int j = 0; j< 9;j++){
                if(board[i][j]!='.'){
                    if(row[i].contains(board[i][j])||col[j].contains(board[i][j])
                            ||cell[3*(i/3)+j/3].contains(board[i][j]))
                        return false;
                    else{
                        row[i].add(board[i][j]);
                        col[j].add(board[i][j]);
                        cell[3*(i/3)+j/3].add(board[i][j]);
                    }
                }

            }
        }
        return true;
    }
}
