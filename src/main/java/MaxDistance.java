import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created on 2020/3/29.
 *
 * @author ray
 */
public class MaxDistance {


    public static int maxDistance2(int[][] grid) {
        if (grid.length == 0) {
            return -1;
        }

        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};

        Queue<int[]> queue = new ArrayDeque<>();
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[] pointer = null;

        boolean hasOcean = false;
        while (!queue.isEmpty()) {
            pointer = queue.poll();
            int x = pointer[0];
            int y = pointer[1];

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX < 0 || newX >= rows || newY < 0 || newY >= cols || grid[newX][newY] != 0) {
                    continue;
                }

                grid[newX][newY] = grid[x][y] + 1;
                hasOcean = true;
                queue.offer(new int[] {newX, newY});
            }
        }

        if (pointer == null || !hasOcean) {
            return -1;
        }

        return grid[pointer[0]][pointer[1]] - 1;
    }

    public static int maxDistance(int[][] grid) {
        if (grid.length == 0) {
            return -1;
        }
        int max = -1;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }
                max = Math.max(getMinVal(grid, i, j), max);
            }
        }
        return max;
    }

    private static int getMinVal(int[][] grid, int row, int col) {
        LinkedList<int[]> queue = new LinkedList<>();
        int[][] visited = new int[grid.length][grid[0].length];
        int[] first = {row, col, 0};
        queue.add(first);
        visited[row][col] = 1;

        while (!queue.isEmpty()) {
            int[] pop = queue.pop();
            int i = pop[0];
            int j = pop[1];
            int step = pop[2];
            if (i - 1 >= 0) {
                if (visited[i - 1][j] == 0) {
                    // 如果是访问过的肯定需要加1就没必要比较了
                    int[] tmp = {i - 1, j, step + 1};
                    queue.push(tmp);
                    visited[i - 1][j] = 1;
                    if (grid[i - 1][j] == 1) {
                        return step + 1;
                    }
                }
            }

            if (j - 1 >= 0) {
                if (visited[i][j - 1] == 0) {
                    // 如果是访问过的肯定需要加1就没必要比较了
                    int[] tmp = {i, j - 1, step + 1};
                    queue.push(tmp);
                    visited[i][j - 1] = 1;
                    if (grid[i][j - 1] == 1) {
                        return step + 1;
                    }
                }
            }

            if (i + 1 < grid[0].length) {
                if (visited[i + 1][j] == 0) {
                    // 如果是访问过的肯定需要加1就没必要比较了
                    int[] tmp = {i + 1, j, step + 1};
                    queue.push(tmp);
                    visited[i + 1][j] = 1;
                    if (grid[i + 1][j] == 1) {
                        return step + 1;
                    }
                }
            }

            if (j + 1 < grid[0].length) {
                if (visited[i][j + 1] == 0) {
                    // 如果是访问过的肯定需要加1就没必要比较了
                    int[] tmp = {i, j + 1, step + 1};
                    queue.push(tmp);
                    visited[i][j + 1] = 1;
                    if (grid[i][j + 1] == 1) {
                        return step + 1;
                    }
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] p = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        System.out.println(maxDistance(p));
    }
}
