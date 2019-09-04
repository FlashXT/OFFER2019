package P05_CodeExam.C05_XiaoHongShu.Problem3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/3,19:31
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
//Leetcode 354
public class Main {
    static class Node{
        int x;
        int h;
        public Node(int x,int h){
            this.x = x;
            this.h = h;
        }
    }
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Comparator<Node> cmp1 = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                    return o1.x - o2.x;
            }
        };
        Comparator<Node> cmp2 = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.h - o2.h;
            }
        };
        Node [] arr = new Node[n];
        for(int i = 0; i < n;i++ ){
            arr[i] = new Node(scan.nextInt(),scan.nextInt());
        }
        Arrays.sort(arr,cmp1);
        Arrays.sort(arr,cmp2);

        int res = 1;
        Node temp = arr[0];
        for(int i = 1; i < arr.length;i++){

            if(compare(arr[i],temp)){
                res++;
                temp = arr[i];
            }
        }
        System.out.println(res);

    }
    public static boolean compare(Node n1,Node n2){
        if(n1.x >= n2.x && n1.h >= n2.h){
            return true;
        }
        return false;
    }
}
