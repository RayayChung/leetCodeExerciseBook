import java.util.*;
import java.util.stream.Collectors;

/**
 * Created on 2020/2/26.
 *
 * @author ray
 */
public class SolveQueens {

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> returnList = new ArrayList<>();
        boolean[] rows = new boolean[n];
        boolean[] setLeft = new boolean[2 * n];
        boolean[] setRight = new boolean[2 * n];
        int[] tmpArray = new int[n];
        backtrack(rows, setLeft, setRight, returnList, tmpArray,0, n);
        return returnList;
    }

    private static void backtrack(boolean[] rows, boolean[] setLeft, boolean[] setRight,
                                  List<List<String>> returnList, int[] tmpArray, int level, int n) {

        if (level == n) {
            returnList.add(buildString(tmpArray));
            return;
        }

        for (int index = 0; index < n; index++) {
            if (rows[index] || setLeft[level + index] || setRight[index - level + n]) {
                continue;
            }

            tmpArray[level] = index;
            rows[index] = true;
            setLeft[index + level] = true;
            setRight[index - level + n] = true;
            backtrack(rows, setLeft, setRight, returnList, tmpArray, level + 1, n);
            tmpArray[level] = 0;
            rows[index] = false;
            setLeft[index + level] = false;
            setRight[index - level + n] = false;
        }
    }

    private static List<String> buildString(int[] tmpArray) {
        int size = tmpArray.length;
        return Arrays.stream(tmpArray)
                .mapToObj(i -> {
                    StringBuilder sb = new StringBuilder();
                    for (int idx = 0; idx < size; idx++) {
                        if (idx == i) {
                            sb.append("Q");
                        } else {
                            sb.append(".");
                        }
                    }
                    return sb.toString();
                })
                .collect(Collectors.toList());
    }

//    private static void backtrack(int index, List<String> tmpList, List<List<String>> returnList, int level, int n) {
//        if (level > 0) {
//            for (int i = 0; i < tmpList.size(); i++) {
//                int interval = level - i;
//                String text = tmpList.get(i);
//                if (text.charAt(index) == 'Q') {
//                    return;
//                }
//                if (index - interval >= 0 && text.charAt(index - interval) == 'Q') {
//                    return;
//                }
//                if (index + interval <= n - 1 && text.charAt(index + interval) == 'Q') {
//                    return;
//                }
//            }
//        }
//        tmpList.add(getString(index, n));
//        for (int i = 0; i < n; i++) {
//            if (i == n - 1) {
//                if (tmpList.size() == n) {
//                    returnList.add(tmpList);
//                    return;
//                }
//            }
//            List<String> tmpList1 = new ArrayList<>();
//            for (int j = 0; j < level + 1; j++) {
//                tmpList1.add(tmpList.get(j));
//            }
//            backtrack(i, tmpList1, returnList, level + 1, n);
//        }
//    }
//
//    private static String getString(int index, int n) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < n; i++) {
//            if (index == i) {
//                sb.append("Q");
//            } else {
//                sb.append(".");
//            }
//        }
//        return sb.toString();
//    }

    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(4);
        System.out.println("haha");
    }
}
