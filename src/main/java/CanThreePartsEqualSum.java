import java.util.Arrays;

/**
 * Created on 2020/3/11.
 *
 * @author ray
 */
public class CanThreePartsEqualSum {

    public static boolean canThreePartsEqualSum(int[] A) {
        if (A == null || A.length <= 2) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        if (sum % 3 != 0) {
            return false;
        }
        int value = sum / 3;
        int count = 0;
        int flag = 0;
        for (int i = 0; i < A.length; i++) {
            int aA = A[i];
            flag += aA;
            if (flag == value) {
                if (count < 2) {
                    count++;
                    flag = 0;
                } else if (count == 2 && i == A.length - 1) {
                    count++;
                }
            }
        }
        return count == 3 && flag == value;
    }

    public static void main(String[] args) {
        int[] A ={1,-1,1,-1};
        System.out.println(canThreePartsEqualSum(A));
    }
}
