package DataStructure.CH9_JavaCollection;

/***********************************************************************
 * 并查集
 * 并查集是一种树型的数据结构，用于处理一些不相交集合（Disjoint Sets）的合并及查询
 * 问题。常常在使用中以森林来表示。集就是让每个元素构成一个单元素的集合，并就是按一定
 * 顺序将属于同一组的元素所在的集合合并。
 *
 * 并查集的主要操作：
 * 1、初始化：把每个点所在集合初始化为其自身,大小为1，指针指向自身；
 * 2、查找：查找元素所在的集合即根节点；
 * 3、合并：将两个元素所在的集合合并为一个集合，合并两个不相交集合判断两个元素是否属于
 *         同一集合。
 *
 * 并查集的时间复杂度:
 *     并查集进行n次查找的时间复杂度是O(n )（执行n-1次合并和m≥n次查找）。其中 是一
 * 个增长极其缓慢的函数，它是阿克曼函数（Ackermann Function）的某个反函数。它可以看
 * 作是小于5的。所以可以认为并查集的时间复杂度几乎是线性的。
 *************************************************************************/
public class UnionFindSet {

    public static void main(String []args){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        System.out.println(unionFind(node1,node2));
        System.out.println(unionFind(node1,node2));
        System.out.println(unionFind(node1,node3));
        System.out.println(findParent2(node1).value);
        System.out.println(findParent2(node2).value);
        System.out.println(findParent2(node3).value);
    }
    public static boolean unionFind(Node node1,Node node2){
            Node node1p = findParent2(node1);
            Node node2p = findParent2(node2);

            if(node1p == node2p)
                return true;
            else{
                if(node1p.size > node2p.size){
                    node2p.parent = node1p;
                    node1p.size += node2p.size;
                }
                else{
                    node1p.parent = node2p;
                    node2p.size += node1p.size;
                }
                return false;
            }
    }
    //先查找再降低树的高度
    public static Node findParent(Node node){
        Node ptr = node;
        while(ptr.parent!= ptr){
            ptr = ptr.parent;
        }
        Node ptr2;
        while(node!= ptr){
            ptr2 = node.parent;
            node.parent = ptr;
            node = ptr2;
        }
        return ptr;
    }
    //递归查找并降低树的高度
    public static Node findParent2(Node node){
        Node temp = node.parent;
        if(node.parent!= node)
            temp = findParent2(node.parent);
        node.parent = temp;
        return temp;
    }

}

class Node{
    public int value;
    public int size;
    public Node parent;
    public Node(){}
    public Node(int value){
        this.value = value;
        this.size = 1;
        this.parent = this;
    }
}
