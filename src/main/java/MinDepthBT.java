/**
 * Created on 2020/2/24.
 *
 * @author ray
 */

//给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//
// 给定二叉树 [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最小深度 2.
// Related Topics 树 深度优先搜索 广度优先搜索

public class MinDepthBT {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            if (left == 0 && right == 0) {
                return 1;
            } else if (right == 0) {
                return 1 + left;
            } else if (left == 0){
                return 1 + right;
            } else {
                return 1 + (left > right ? right : left);
            }
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
