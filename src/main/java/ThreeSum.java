import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created on 2020/2/18.
 *
 * @author ray
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < len - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            int min = nums[i] + nums[i + 1] + nums[i + 2];
            if (min > 0) {
                break;
            }
            int max = nums[i] + nums[len - 2] + nums[len - 1];
            if (max < 0) {
                continue;
            }
            // 很重要去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int a = nums[i];
            int head = i + 1;
            int tail = len - 1;
            while (head < tail) {
                int sum = a + nums[head] + nums[tail];
                if (sum == 0) {
                    list.add(Arrays.asList(a, nums[head], nums[tail]));
                    // 很重要去重
                    while (head < tail && nums[head] == nums[head+1]) {
                        head ++;
                    }
                    while (head < tail && nums[tail] == nums[tail - 1]) {
                        tail --;
                    }
                    head ++;
                    tail --;
                } else if (sum > 0) {
                    tail --;
                } else {
                    head ++;
                }
            }
        }
        return list;
    }
}
