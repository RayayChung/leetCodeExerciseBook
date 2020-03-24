/**
 * Created on 2020/3/23.
 *
 * @author ray
 */
public class NumIslands {

    public static int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int cols = grid[0].length;
        int[][] index = new int[grid.length][cols];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < cols; j++) {
                index[i][j] = grid[i][j] == '0' ? -1 : i * cols + j;
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < cols; j++) {
                if (index[i][j] == -1) {
                    continue;
                }
                int topRoot = -1;
                int leftRoot = -1;
                if (i - 1 >= 0 && index[i - 1][j] != -1) {
                    topRoot = findRoot(index, i - 1, j, cols);
                }
                if (j - 1 >= 0 && index[i][j - 1] != -1) {
                    leftRoot = findRoot(index, i, j - 1, cols);
                }
                if (topRoot != -1) {
                    index[i][j] = topRoot;
                    if (leftRoot != -1) {
                        index[leftRoot / cols][leftRoot % cols] = topRoot;
                        index[i][j] = topRoot;
                    }
                } else if (leftRoot != -1) {
                    index[i][j] = leftRoot;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < cols; j++) {
                if (index[i][j] == i * cols + j && grid[i][j] != '0') {
                    count++;
                }
            }
        }
        return count;
    }

    private static int findRoot(int[][] index, int i, int j, int cols) {
        while (index[i][j] != i * cols + j) {
            int val = index[i][j];
            i = val / cols;
            j = val % cols;
        }
        return index[i][j];
    }

    public static void main(String[] args) {
        char[][] ch = {{'1'}};
        System.out.println(numIslands(ch));
    }
}
