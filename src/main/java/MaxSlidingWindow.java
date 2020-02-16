import java.util.Deque;
import java.util.LinkedList;

/**
 * Created on 2020/2/16.
 *
 * @author ray
 */
public class MaxSlidingWindow {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int[] returnArray = new int[nums.length - k + 1];
        Deque<Integer> slidingWindow = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= k && slidingWindow.peek() <= i - k) {
                slidingWindow.pop();
            }
            while (slidingWindow.size() > 0 && nums[i] >= nums[slidingWindow.peekLast()]) {
                slidingWindow.removeLast();
            }
            slidingWindow.addLast(i);
            if (i >= k - 1) {
                returnArray[index] = nums[slidingWindow.peek()];
                index ++;
            }
        }
        return returnArray;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 1, 2, 0, 5};
        int[] ints = maxSlidingWindow(a, 3);
        System.out.println(ints);
    }
}
