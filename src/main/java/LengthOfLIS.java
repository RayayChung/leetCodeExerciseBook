/**
 * Created on 2020/3/18.
 *
 * @author ray
 */
public class LengthOfLIS {

    public static int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int globalMax = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (max == 0) {
                        max = dp[j];
                    } else if (max < dp[j]) {
                        max = dp[j];
                    }
                }
            }
            if (globalMax < max + 1) {
                globalMax = max + 1;
            }
            dp[i] = max + 1;
        }
        return globalMax;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }
}
