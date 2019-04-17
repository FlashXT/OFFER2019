package DataStructure.CH9_Search;

/**********************************************************************************
 *                              二叉排序树
 * 1.定义：
 *    二叉排序树或者是一棵空树，或者是具有下列性质的二叉树：
 *      （1）若左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 *      （2）若右子树不空，则右子树上所有结点的值均大于或等于它的根结点的值；
 *      （3）左、右子树也分别为二叉排序树；
 *2.查找过程：
 *    二叉排序树的查找可以用递归来实现:
 *     先将要查找的关键字和根节点进行比较;
 *          若和根节点值相同，则返回根节点值；
 *          若比根节点小，就递归查找左子树;
 *          若比根节点大，则递归查找右子树。
 *3.插入：
 *      二叉排序树是一种动态树表。其特点是，树的结构通常不是一次生成的，而是在查找过程中，
 *      当树中不存在关键字等于给定值的结点时再进行插入。新插入的结点一定是一个新添加的叶
 *      子结点，并且是查找不成功时查找路径上访问的最后一个结点的左孩子或右孩子结点。
 *
 *      先调用查找操作将要插入的关键字进行比较：
 *         如果在原有的二叉排序树中没有要插入的关键字，则将关键字与查找的结点p（在查找操
 *         作中返回的结点）的值进行比较：
 *              若p为空，则插入关键字赋值给该节点；
 *              若小于结点p的值，则插入关键字作为结点p的左子树；
 *              若大于结点p的值，则插入关键字作为结点p的右子树；
 *4.删除：
 *      二叉排序树的删除操作相对复杂，因为不能因为删除了结点，让这颗二叉排序树变得不满足二叉
 *      排序树的性质，所以对于二叉排序树的 P结点 存在三种情况：
 *          ① P结点为 叶子结点；（直接删除P结点即可）
 *          ② P结点 仅有左或者右子树的结点；（删除P结点后，将它的左子树或者右子树整个移动到
 *             删除结点的位置）
 *          ③ P结点 既有左子树又右子树：（将P结点的直接前驱或者直接后继作为删除结点的数据）
 *
 ***********************************************************************************/
public class BinarySortTree {
}