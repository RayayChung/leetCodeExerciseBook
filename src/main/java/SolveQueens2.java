/**
 * Created on 2020/2/27.
 *
 * @author ray
 */
public class SolveQueens2 {

    public static int totalNQueens(int n) {
        boolean[] rows = new boolean[n];
        boolean[] setLeft = new boolean[2 * n];
        boolean[] setRight = new boolean[2 * n];
        int[] tmpArray = new int[n];
        return backtrack(rows, setLeft, setRight, tmpArray,0, n);
    }

    private static int backtrack(boolean[] rows, boolean[] setLeft, boolean[] setRight,
                                  int[] tmpArray, int level, int n) {
        int counter = 0;
        if (level == n) {
            return 1;
        }

        for (int index = 0; index < n; index++) {
            if (rows[index] || setLeft[level + index] || setRight[index - level + n]) {
                continue;
            }

            tmpArray[level] = index;
            rows[index] = true;
            setLeft[index + level] = true;
            setRight[index - level + n] = true;
            counter += backtrack(rows, setLeft, setRight, tmpArray, level + 1, n);
            tmpArray[level] = 0;
            rows[index] = false;
            setLeft[index + level] = false;
            setRight[index - level + n] = false;
        }
        return counter;
    }

}
