import java.util.Stack;

/**
 * Created on 2020/4/1.
 *
 * @author ray
 */
public class MaxDepthAfterSplit {

    public static int[] maxDepthAfterSplit(String seq) {
        if (seq == null || "".equals(seq)) {
            return new int[]{};
        }
        if (seq.length() == 1) {
            return new int[] {1};
        }
        char[] chars = seq.toCharArray();
        int depth = 0;
        int[] returnArray = new int[seq.length()];
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if ('(' == aChar) {
                depth ++;
                returnArray[i] = depth % 2;
            } else {
                returnArray[i] = depth % 2;
                depth --;
            }
        }
        return returnArray;
    }

    public static void main(String[] args) {
        String s = "(()())";
        int[] ints = maxDepthAfterSplit(s);
        System.out.println("haha");
    }
}
