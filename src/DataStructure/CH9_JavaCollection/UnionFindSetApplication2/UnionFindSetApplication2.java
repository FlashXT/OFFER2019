package DataStructure.CH9_JavaCollection.UnionFindSetApplication2;


import java.util.*;

class person{
    int id;
    int size = 0;
    person parent;
    public person(int id){
        this.id = id;
        this.size =1;
        this.parent = this;
    }
}
public class UnionFindSetApplication2{

    public static void main(String [] args){
        Scanner scan= new Scanner(System.in);
        int lines = scan.nextInt();
        int i =0;
        String [] str = new String[lines];
        scan.nextLine();
        while(scan.hasNextLine()){
            str[i++] = scan.nextLine();
            if(i == str.length)break;
        }
//        System.out.println(Arrays.toString(str));

        person []p = new person[lines+1];
        String []ch;
        int temp ;
        for(i = 1; i <= str.length;i++){
            if(p[i] == null){
                p[i] = new person(i);
            }
            ch = str[i-1].split("\\s+");
            for(int j = 0; j<ch.length-1;j++){
                temp = Integer.valueOf(ch[j]);
                if(p[temp]==null)
                    p[temp] = new person(temp);
                Union(p[i],p[temp]);
            }
        }
        Set set= new HashSet<String>();
        for(i =1;i< p.length;i++){
            set.add(p[i].parent.id);
        }
        System.out.println(set.size());

    }
    public static person findparent(person p){
        person parent = p.parent;
        if(p.parent!=p){
           parent =  findparent(p.parent);
        }
        p.parent = parent;
        return parent;
    }

    public static void  Union(person p1,person p2){
        person p1p = findparent(p1);
        person p2p = findparent(p2);
        if( p1p == p2p)
            return ;
        else{
            if(p1p.size > p2p.size){
                p2p.parent = p1p;
                p1p.size += p2p.size;
            }
            else{
                p1p.parent = p2p;
                p2p.size += p1p.size;
            }
        }
    }
}