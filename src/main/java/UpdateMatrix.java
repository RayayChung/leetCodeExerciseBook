import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created on 2020/4/15.
 *
 * @author ray
 */
public class UpdateMatrix {

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null) {
            return null;
        }

        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};

        Stack<int[]> stack = new Stack<>();

        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                stack.push(new int[]{i, j , 1});

                int min = -1;
                while (!stack.isEmpty()) {
                    int[] pop = stack.pop();
                    int x = pop[0];
                    int y = pop[1];

                    for (int k = 0; k < 4; k++) {
                        int newX = x + dx[k];
                        int newY = y + dy[k];

                        if (newX < 0 || newX >= rows || newY < 0 || newY >= cols) {
                            continue;
                        }

                        if (matrix[newX][newY] == 0) {
                            min = pop[2];
                            break;
                        } else {
                            stack.push(new int[]{newX, newY , pop[2] + 1});
                        }
                    }

                    if (min >= 1) {
                        matrix[i][j] = min;
                        break;
                    }
                }

                stack.clear();
            }
        }

        return matrix;
    }
}
