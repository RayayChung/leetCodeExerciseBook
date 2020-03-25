/**
 * Created on 2020/3/24.
 *
 * @author ray
 */
public class FindCircleNum {

    public int findCircleNum(int[][] M) {
        int[] unionSet = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            unionSet[i] = i;
        }

        for (int i = 0; i < M.length; i++) {
            for (int j = i; j < M.length; j++) {
                if (M[i][j] == 1) {
                    int iRoot = findRoot(unionSet, i);
                    int jRoot = findRoot(unionSet, j);
                    if (iRoot != jRoot) {
                        unionSet[jRoot] = iRoot;
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (unionSet[i] == i) {
                count++;
            }
        }
        return count;
    }

    private int findRoot(int[] unionSet, int i) {
        while (unionSet[i] != i) {
            i = unionSet[i];
        }
        return unionSet[i];
    }
}
