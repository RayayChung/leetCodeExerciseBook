import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created on 2020/2/25.
 *
 * @author ray
 */

//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
//
// 例如，给出 n = 3，生成结果为：
//
// [
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
//
// Related Topics 字符串 回溯算法

public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> returnList = new ArrayList<>();
        helper(0, 0, "", returnList, n);
        return returnList;
    }

    private void helper(int left, int right, String str, List<String> list, int n) {
        if (left == n && right == n) {
            list.add(str);
            return;
        }
        if (left < n) {
            helper(left + 1, right, str + "(", list, n);
        }
        if (right < left && right < n) {
            helper(left, right + 1, str + ")", list, n);
        }
    }

}
