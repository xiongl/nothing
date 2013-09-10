import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Xiong
 * Date: 13-8-28
 * Time: 下午10:06
 * To change this template use File | Settings | File Templates.
 */
public class LongestParentheses {
    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s==null)
            return 0;
        int curr = 0;
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (ch=='(') {
                stack.push(curr+2);
                curr = 0;
            } else {
                if (!stack.empty()) {
                    curr = curr + stack.pop();
                    if (curr > max)
                        max = curr;
                } else
                    curr = 0;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        new LongestParentheses().longestValidParentheses("()");
    }
}
