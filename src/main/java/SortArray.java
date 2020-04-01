import java.util.Random;

/**
 * Created on 2020/3/31.
 *
 * @author ray
 */
public class SortArray {

    private Random random = new Random();

    public int[] sortArray(int[] nums) {
        randomizedQuickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void randomizedQuickSort(int[] nums, int l, int r) {
        if (l < r) {
            int pos = randomPosition(l, r, nums);
            randomizedQuickSort(nums, l, pos - 1);
            randomizedQuickSort(nums, pos + 1, r);
        }
    }

    private int randomPosition(int l, int r, int[] nums) {
        int i = random.nextInt(r - l + 1);
        int position = l + i;
        swap(r, position, nums);
        return partition(nums, l, r);
    }

    private void swap(int first, int second, int[] nums) {
        int num = nums[first];
        int tmp = nums[second];
        nums[second] = num;
        nums[first] = tmp;
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(i, j ,nums);
            }
        }
        swap(i + 1, r , nums);
        return i + 1;
    }
}
