import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created on 2020/2/16.
 *
 * @author ray
 */

//设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
//
// 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返
//回当前数据流中第K大的元素。
//
// 示例:
//
//
//int k = 3;
//int[] arr = [4,5,8,2];
//KthLargest kthLargest = new KthLargest(3, arr);
//kthLargest.add(3);   // returns 4
//kthLargest.add(5);   // returns 5
//kthLargest.add(10);  // returns 5
//kthLargest.add(9);   // returns 8
//kthLargest.add(4);   // returns 8
//
//
// 说明:
//你可以假设 nums 的长度≥ k-1 且k ≥ 1。
// Related Topics 堆

public class KthLargest {

    private final PriorityQueue<Integer> heap;

    private final int size;

    public KthLargest(int k, int[] nums) {
        this.size = k;
        heap = new PriorityQueue<>(size);
        for (int num : nums) {
            heap.add(num);
        }
    }

    public int add(int val) {
        if (heap.size() < size) {
            heap.offer(val);
        } else if (heap.peek() < val) {
            heap.poll();
            heap.offer(val);
        }
        return heap.peek();
    }
}
