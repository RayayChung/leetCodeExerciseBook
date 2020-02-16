/**
 * Created on 2020/2/15.
 *
 * @author ray
 */
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }
        ListNode tmp = head;
        int count = 1;
        while (tmp.next != null) {
            tmp = tmp.next;
            count ++;
            if (count == k) {
                break;
            }
        }
        if (count < k) {
            return head;
        }
        ListNode reversedGroup = reverseKGroup(tmp, k);
        ListNode listNode = reverseList2(head, tmp);
        head.next = reversedGroup;
        return listNode;
    }

    public static ListNode reverseList2(ListNode head, ListNode tmp) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next == tmp) {
            return head;
        }
        ListNode listNode = reverseList2(head.next, tmp);
        head.next.next = head;
        head.next = null;
        return listNode;
    }

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {

        int val;

        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}
