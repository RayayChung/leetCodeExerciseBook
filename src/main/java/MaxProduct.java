import java.util.Arrays;

/**
 * Created on 2020/3/16.
 *
 * @author ray
 */
public class MaxProduct {

    public static int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] maxValues = new int[nums.length];
        maxValues[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                nums[j] *= nums[i];
            }

            if (maxValues[i - 1] >= nums[i]) {
                maxValues[i] = maxValues[i - 1];
            } else {
                maxValues[i] = nums[i];
            }
        }
        return maxValues[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(maxProduct(nums));
    }
}
