package P01_DataStructure.CH6_Graph.MinCostSpanningTree;

import java.util.HashSet;
import java.util.Iterator;

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
 *     并查集进行n次查找的时间复杂度是O(M Alpha(N))（执行n-1次合并和m≥n次查找）。
 *  其中Alpha(N)是一个增长极其缓慢的函数，它是阿克曼函数（Ackermann Function）的某
 *  个反函数。它可以看作是小于5的。所以可以认为并查集的时间复杂度几乎是线性的。
 *
 *************************************************************************/
public class UnionFindSet {
    private HashSet<Node> nodeset;

    public UnionFindSet(int nodes){
        this.nodeset = new HashSet<>(nodes);
        for(int i = 0; i < nodes;i++)
            this.nodeset.add(new Node(i));
    }

    //递归查找并降低树的高度
    public Node findParent(Node node){
        Node temp = node.parent;
        if(node.parent!= node)
            temp = findParent(node.parent);
        node.parent = temp;
        return temp;
    }
    public  boolean isconnected(int v1,int v2){

        Node node1 = this.getNode(v1);
        Node node2 = this.getNode(v2);
        Node node1p = findParent(node1);
        Node node2p = findParent(node2);

        if(node1p == node2p)
            return true;
        return false;
    }
    public void connect(int v1 ,int v2){
        Node node1 = this.getNode(v1);
        Node node2 = this.getNode(v2);
        Node node1p = findParent(node1);
        Node node2p = findParent(node2);
        if(node1p.size > node2p.size){
            node2p.parent = node1p;
            node1p.size += node2p.size;
        }
        else{
            node1p.parent = node2p;
            node2p.size += node1p.size;
        }
    }
    public Node getNode(int v){

        Iterator<Node> iter = this.nodeset.iterator();
        while(iter.hasNext()){
            Node node = iter.next();
            if(node.value == v)
                return node;
        }
        return null;
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
