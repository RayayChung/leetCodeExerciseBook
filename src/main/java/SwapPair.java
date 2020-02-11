/**
 * Created on 2020/2/11.
 *
 * @author ray
 */

//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//
//
// 示例:
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
//
// Related Topics 链表

public class SwapPair {

    /**
     * 觉得递归算法是比较好理解的一种，默认后面的链表已经两两交换好了(2个后面)
     * 需要单独考虑head.next与head.next.next为null的情况
     * 与{@link ReverseLinkedList}
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            ListNode pointer = head.next;
            pointer.next = head;
            head.next = null;
            return pointer;
        }
        ListNode swapPairs = swapPairs(head.next.next);
        ListNode pointer = head.next;
        pointer.next = head;
        head.next = swapPairs;
        return pointer;
    }

    /**
     * 迭代算法,需要注意prevNode用于在下一次循环的时候更新上一次交换后第二个节点对应的next
     *
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prevNode = dummy;

        while ((head != null) && (head.next != null)) {

            // Nodes to be swapped
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            // Swapping
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // Reinitializing the head and prevNode for next swap
            prevNode = firstNode;
            head = firstNode.next; // jump
        }

        // Return the new head node.
        return dummy.next;
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
