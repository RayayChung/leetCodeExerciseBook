/**
 * Created on 2020/2/28.
 *
 * @author ray
 */

//编写一个程序，通过已填充的空格来解决数独问题。
//
// 一个数独的解法需遵循如下规则：
//
//
// 数字 1-9 在每一行只能出现一次。
// 数字 1-9 在每一列只能出现一次。
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
//
//
// 空白格用 '.' 表示。
//
//
//
// 一个数独。
//
//
//
// 答案被标成红色。
//
// Note:
//
//
// 给定的数独序列只包含数字 1-9 和字符 '.' 。
// 你可以假设给定的数独只有唯一解。
// 给定数独永远是 9x9 形式的。
//
// Related Topics 哈希表 回溯算法

public class SolveSudoku {

    public static void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] boxes = new int[9][9];
        prepareTheLimit(row, col, boxes, board);
        solve(board, row, col, boxes);
    }

    public static boolean solve(char[][] board, int[][] row, int[][] col, int[][] boxes) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        int convertValue = c - 49;
                        if (isValid(i, j, convertValue, row, col, boxes)) {
                            board[i][j] = c;
                            row[i][convertValue] += 1;
                            col[j][convertValue] += 1;
                            boxes[getIndex(i, j)][convertValue] += 1;
                            if (solve(board, row, col, boxes)) {
                                return true;
                            }
                            board[i][j] = '.';
                            row[i][convertValue] -= 1;
                            col[j][convertValue] -= 1;
                            boxes[getIndex(i, j)][convertValue] -= 1;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(int idxRow, int idxCol, int ch, int[][] row, int[][] col, int[][] boxes) {
        return row[idxRow][ch] == 0 && col[idxCol][ch] == 0 && boxes[getIndex(idxRow, idxCol)][ch] == 0;
    }

    private static void prepareTheLimit(int[][] row, int[][] col, int[][] boxes, char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    int convertValue = ch - 49;
                    row[i][convertValue] += 1;
                    col[j][convertValue] += 1;
                    boxes[getIndex(i, j)][convertValue] += 1;
                }
            }
        }
    }

    private static int getIndex(int i, int j) {
        int p;
        if (i >= 0 && i <= 2) {
            p = 0;
        } else if (i >= 3 && i <= 5) {
            p = 1;
        } else {
            p = 2;
        }

        if (j >= 0 && j <= 2) {
            return p;
        } else if (j >= 3 && j <= 5) {
            return p + 3;
        } else {
            return p + 6;
        }
    }

    public static void main(String[] args) {
        char[][] arr = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        solveSudoku(arr);
        System.out.println("hahah");
    }
}
