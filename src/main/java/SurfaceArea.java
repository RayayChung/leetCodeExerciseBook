/**
 * Created on 2020/3/25.
 *
 * @author ray
 */
public class SurfaceArea {

    public static int surfaceArea(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int current = grid[i][j];
                if (current == 0) {
                    continue;
                }
                if (i - 1 >= 0 && grid[i - 1][j] != 0) {
                    int top = grid[i - 1][j];
                    if (top < current) {
                        count = count + current - 2 * top;
                    } else {
                        count = count - current;
                    }
                } else {
                    count += current;
                }
                if (j - 1 >= 0 && grid[i][j - 1] != 0) {
                    int left = grid[i][j - 1];
                    if (left < current) {
                        count = count + (current - left) - left;
                    } else {
                        count = count - current;
                    }
                } else {
                    count += current;
                }
                count += 2 * (current + 1);
            }
        }
        return count;
    }
}
