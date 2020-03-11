/**
 * Created on 2020/2/28.
 *
 * @author ray
 */
public class IsValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] boxes = new int[9][9];
        return helper(board, row, col, boxes);
    }

    private static boolean helper(char[][] board, int[][] row, int[][] col, int[][] boxes) {
        for (int idxRow = 0; idxRow < 9; idxRow++) {
            for (int idxCol = 0; idxCol < 9; idxCol++) {
                char cha = board[idxRow][idxCol];
                if (cha == '.') {
                    continue;
                }
                int ch = ((int) cha) - 49;
                if (row[idxRow][ch] == 1 || col[idxCol][ch] == 1 || boxes[getIndex(idxRow, idxCol)][ch] == 1) {
                    return false;
                }
                row[idxRow][ch] += 1;
                col[idxCol][ch] += 1;
                boxes[getIndex(idxRow, idxCol)][ch] += 1;
            }
        }
        return true;
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
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(board));
    }
}
