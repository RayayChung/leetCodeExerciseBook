import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created on 2020/2/21.
 *
 * @author ray
 */
public class InorderTraversal {

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalRecurse(TreeNode root) {
        List<Integer> returnList = new ArrayList<>();
        if (root == null) {
            return returnList;
        }
        returnList.addAll(inorderTraversalRecurse(root.left));
        returnList.add(root.val);
        returnList.addAll(inorderTraversalRecurse(root.right));
        return returnList;
    }

    /**
     * 利用栈的中序递归
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> returnList = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null || stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode pop = stack.pop();
            returnList.add(pop.val);
            curr = pop.right;
        }
        return returnList;
    }

    public static class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
