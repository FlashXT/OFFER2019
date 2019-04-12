package DataStructure.CH7_JavaCollection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/************************************************************************
 *【问题描述】
 *        若某个家族人员过于庞大，要判断两个是否是亲戚，确实还很不容易，现在给出某个
 *    亲戚关系图，求任意给出的两个人是否具有亲戚关系。
 *        规定：x和y是亲戚，y和z是亲戚，那么x和z也是亲戚。如果x,y是亲戚，那么x的亲
 *    戚都是y的亲戚，y的亲戚也都是x的亲戚。
 *
 *【输入】
 *      第一行：三个整数n,m,p，（n<=5000,m<=5000,p<=5000），分别表示有n个人，
 *             m个亲戚关系，询问p对亲戚关系。
 *      以下m行：每行两个数Mi，Mj，1<=Mi，Mj<=N，表示Ai和Bi具有亲戚关系。
 *      接下来p行：每行两个数Pi，Pj，询问Pi和Pj是否具有亲戚关系。
 *【输出】
 *     P行，每行一个‘Yes’或‘No’。表示第i个询问的答案为“具有”或“不具有”亲戚关系。
 *
 *【样例输入】
 * 9 7 3
 * 2 4
 * 5 7
 * 1 3
 * 8 9
 * 1 2
 * 5 6
 * 2 3
 * 2 5
 * 2 4
 * 3 8
 *【样例输出】
 * false
 * true
 * false
 ***************************************************************************/
public class UnionFindSetApplication {

    public static void main(String [] args){
        //读取数据
        Scanner scan = new Scanner(System.in);
        int numlen = scan.nextInt();
        int pair1 = scan.nextInt();
        int pair2 = scan.nextInt();
        int [][]  pair = new int[pair1+pair2][2];
        int i = 0;
        String str;
        String [] ch;
        scan.nextLine();
        Set s = new HashSet();
        while(scan.hasNextLine()){
            str = scan.nextLine();
            ch = str.split(" ");
            pair[i][0] = Integer.valueOf(ch[0]);
            pair[i][1] = Integer.valueOf(ch[1]);
            s.add(pair[i][0]);
            s.add(pair[i++][1]);
            if(i == pair.length) break;
        }
        //建立结点集
        Node [] node = new Node[numlen];
        i = 0;
        Iterator<Integer> it = s.iterator();
        while(it.hasNext()){
            node[i++] = new Node(it.next());
        }

        //建立亲戚关系
        i = 0;
        Node temp1,temp2;
        while( i < pair1){
            temp1 = getNode(node,pair[i][0]);
            temp2 = getNode(node,pair[i][1]);
            UnionFindSet.unionFind(temp1,temp2);
            i++;
        }
        //输出是否具有亲戚关系
        i = 0;
        while( i < pair2){
            temp1 = getNode(node,pair[pair1+i][0]);
            temp2 = getNode(node,pair[pair1+i][1]);
            System.out.println(UnionFindSet.unionFind(temp1,temp2));
            i++;
        }

    }
    public static Node getNode(Node[]node , int value){
        int i = 0;
        while(i < node.length )
        {
            if(node[i].value == value){
                return node[i];
            }
            i++;
        }
        return null;
    }
}
