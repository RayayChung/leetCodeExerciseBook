import java.util.Stack;

/**
 * Created on 2020/4/14.
 *
 * @author ray
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = getStack(l1);
        Stack<Integer> s2 = getStack(l2);

        ListNode returnNode = null;
        int incr = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (returnNode == null) {
                int value = s1.pop() + s2.pop();
                if (value >= 10) {
                    value -= 10;
                    incr = 1;
                }
                returnNode = new ListNode(value);
            } else {
                int value = (s1.isEmpty() ? 0 : s1.pop()) + (s2.isEmpty() ? 0 : s2.pop()) + incr;
                if (value >= 10) {
                    value -= 10;
                    incr = 1;
                }
                ListNode tmp = new ListNode(value);
                tmp.next = returnNode;
                returnNode = tmp;
            }
        }
        if (incr == 1) {
            ListNode tmp = new ListNode(1);
            tmp.next = returnNode;
            return tmp;
        }
        return returnNode;
    }

    private Stack<Integer> getStack(ListNode l1) {
        Stack<Integer> stack = new Stack<>();
        while (l1 != null) {
            stack.push(l1.val);
            l1 = l1.next;
        }
        return stack;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
    }
}
