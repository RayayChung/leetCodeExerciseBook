/**
 * Created on 2020/2/10.
 *
 * @author ray
 */
//反转一个单链表。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL
//
// 进阶:
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
// Related Topics 链表
public class ReverseLinkedList {

    /**
     * 迭代，
     * 记录当前节点与前一个节点，因为当前节点的next会变为pre，所以还需要一个只想原来的
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {

        ListNode curr = head;
        ListNode pre = null;
        ListNode pointer;

        while (curr != null) {
            pointer = curr.next;
            curr.next = pre;
            pre = curr;
            curr = pointer;
        }
        return pre;
    }

    /**
     * 递归
     *
     * 假设后面的都已经拍好，head.next.next = head，其实是说排序好的最后一个(为啥要用head.next.next-最后要返回的是原来的end对应的Node)
     *
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode listNode = reverseList2(head.next);
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

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        node5.next = null;
        ListNode listNode = reverseList(head);
        ListNode listNode1 = reverseList2(head);
        System.out.println("hhh");
    }
}
