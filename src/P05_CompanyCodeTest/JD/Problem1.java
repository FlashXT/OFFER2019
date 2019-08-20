package P05_CompanyCodeTest.JD;
//6
//2 1
//3 2
//5 2
//4 3
//6 1
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Problem1 {
    static class Node{
        int id;
        int size;
        Node parent;
        public Node(int id){
            this.id = id;
            this.size =1;
            this.parent = this;
        }
    }
    public static void main(String [] args){
        Scanner scan  = new Scanner(System.in);
        //读取结点个数
        int num = scan.nextInt();
        Node[]nodes = new Node[num+1];
        Set<Integer> set = new HashSet<>();
        int i = 0,a,b;
        while(i<num-1){
            a = scan.nextInt();
            b = scan.nextInt();
            if(b==1)
                set.add(a);
            if(nodes[a] == null)
                nodes[a] = new Node(a);
            if(nodes[b] == null)
                nodes[b] = new Node(b);
            Node ptr = nodes[b];
            while(nodes[b].parent!=nodes[b]&&ptr.parent!=nodes[1]){
                ptr = ptr.parent;
            }
            nodes[a].parent = ptr;
            ptr.size++;
            i++;
        }
        Iterator<Integer> iter = set.iterator();
        int max = 0;
        while(iter.hasNext()){
            int temp = iter.next();
            max = max > nodes[temp].size?max:nodes[temp].size;
        }
        System.out.println(max);


    }
}
