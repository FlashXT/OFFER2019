package P03_Algorithm.A03_DynamicProgramming.DP06_ZeroOnePackage;

/********************************************************************
 * 有一个背包，它的容量为C(Capacity).现在有n中不同的物品，编号为0~(n-1),其中
 * 每一件物品的重量为w(i),价值为v(i).问可以向这个背包中盛放那些物品，使得在不超
 * 过背包容量的基础上，物品的总价值最大。
 * 提示：与HouseRobber类似，增加了背包容量这个限制条件，变为二维动态规划；
 ********************************************************************/
public class ZeroOnePackage {
    public  static void main(String[] argrs){
        int [] value = {6,10,12};
        int [] weight = {1,2,3};
        int C =5;
        System.out.println(Method1.ZeroOnePackage(value,weight,C));
        System.out.println(Method2.zeroOnePackage(value,weight,C));
        System.out.println(Method3.zeroOnePackage(value,weight,C));
        System.out.println(Method4.zeroOnePackage(value,weight,C));
    }
}
