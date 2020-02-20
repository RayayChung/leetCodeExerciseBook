import static java.lang.Integer.max;
import static java.lang.Integer.min;
import static java.lang.Integer.rotateLeft;

/**
 * Created on 2020/2/19.
 *
 * @author ray
 */

//给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
// 假设一个二叉搜索树具有如下特征：
//
//
// 节点的左子树只包含小于当前节点的数。
// 节点的右子树只包含大于当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。
//
//
// 示例 1:
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
//
//
// 示例 2:
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
//
// Related Topics 树 深度优先搜索

public class IsValidBST {

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 边界不能用MAX_VALUE和MIN_VALUE
        return isValid(root, null, null);
    }

    private static boolean isValid(TreeNode node, Integer minValue, Integer maxValue) {
        if (node == null) {
            return true;
        }
        if (maxValue != null && node.val >= maxValue) {
            return false;
        }
        if (minValue != null && node.val <= minValue) {
            return false;
        }
        boolean left = node.left == null || isValid(node.left, minValue, node.val);
        boolean right = node.right == null || isValid(node.right, node.val, maxValue);
        return left && right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2147483647);
//        TreeNode left = new TreeNode(1);
//        TreeNode right = new TreeNode(3);
//        root.left = left;
//        root.right = right;
        isValidBST(root);
        System.out.println("haha");
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public static class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
