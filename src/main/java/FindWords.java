import java.util.*;

/**
 * Created on 2020/3/11.
 *
 * @author ray
 */
public class FindWords {

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> returnList = new ArrayList<>();
        Set<Character> firstIndexSet = new HashSet<>();
        Map<Character, List<Integer>> indexMap = new HashMap<>();
        for (String word : words) {
            firstIndexSet.add(word.charAt(0));
        }
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                char ch = board[row][col];
                if (firstIndexSet.contains(ch)) {
                    indexMap.computeIfAbsent(ch, k -> new ArrayList<>()).add(row * 10 + col);
                }
            }
        }
        for (String word : words) {
            if (!indexMap.containsKey(word.charAt(0))) {
                continue;
            }
            for (int count : indexMap.get(word.charAt(0))) {
                Set<Integer> set = new HashSet<>();
                set.add(count);
                if (!returnList.contains(word) && findWord(word, count / 10, count % 10 , board, 0, set)) {
                    returnList.add(word);
                }
            }
        }
        return returnList;
    }

    private static boolean findWord(String word, int row, int col, char[][] board, int index, Set<Integer> set) {
        if (board[row][col] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1 && board[row][col] == word.charAt(index)) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            int rowIndex = row;
            int colIndex = col;
            if (i == 0) {
                rowIndex += 1;
            } else if (i == 1) {
                rowIndex -= 1;
            } else if (i == 3) {
                colIndex += 1;
            } else {
                colIndex -= 1;
            }
            int count = rowIndex * 10 + colIndex;
            if (!set.contains(count) && isInValidIndex(rowIndex, colIndex, board)) {
                set.add(count);
                if (findWord(word, rowIndex, colIndex, board, index +1, set)) {
                    return true;
                }
                set.remove(count);
            }
        }
        return false;
    }

    private static boolean isInValidIndex(int row, int col, char[][] board) {
        return row >= board.length ||
                col == board[0].length ||
                row == -1 ||
                col == -1;
    }

    public static void main(String[] args) {
//        char[][] chars = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
//        String[] words = {"oath","pea","eat","rain"};
        char[][] chars = {{'a', 'a'}};
        String[] words = {"aaa"};
        List<String> words1 = findWords(chars, words);
        System.out.println("haha");
    }

}
