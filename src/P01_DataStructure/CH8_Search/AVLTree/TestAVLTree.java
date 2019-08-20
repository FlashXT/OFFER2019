package P01_DataStructure.CH8_Search.AVLTree;


/**
 * @Author: turboman
 * @Date: 2019/5/11 9:44
 * @Version 1.0
 */
public class TestAVLTree {
    public static void main(String [] args){
//        Student stu1 = new Student(4,"XiaoMing",21);
//        Student stu2 = new Student(2,"XiaoHong",23);
//        Student stu3 = new Student(5,"XiaoZhang",25);
//        Student stu4 = new Student(1,"XiaoLi",22);
//        Student [] stu = {stu1,stu2,stu3,stu4};
//        AVLTree<Student> tree = new AVLTree<>(stu,new StuComparator());
//        tree.preTraverse();
//        tree.midTraverse();
//        tree.RemoveDelete(stu1);
//        tree.midTraverse();
//        Integer [] arr = {4,1,2,3,-1,8,5,9,6,7};
        Integer [] arr = {4,2,5,1};
        AVLTree<Integer> tree = new AVLTree<Integer>(arr);
        tree.preTraverse();
        tree.midTraverse();
//
        tree.RemoveNode(5);
        tree.midTraverse();
        tree.RemoveNode(4);
        tree.midTraverse();
        tree.RemoveNode(1);
        tree.midTraverse();
        System.out.println(tree.Search(4));

//        System.out.println();
    }
}
