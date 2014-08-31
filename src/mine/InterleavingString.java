package mine;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Xiong
 * Date: 13-12-17
 * Time: 下午8:31
 * To change this template use File | Settings | File Templates.
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int cur1 = 0;
        int cur2 = 0;
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1+len2 != len3)
            return false;
        if (len1==0) {
            return s2.equals(s3) ? true : false;
        }
        if (len2==0) {
            return s1.equals(s3) ? true : false;
        }
        Stack<int[]> stack = new Stack<int[]>();
        for (int i=0; i<len3; i++) {
            char c1 = cur1>=len1 ? ' ' : s1.charAt(cur1);
            char c2 = cur2>=len2 ? ' ' : s2.charAt(cur2);
            char c3 = s3.charAt(i);
            if (c3 == c1) {
                if (c3 == c2) {
                    int[] arr = new int[]{i, cur1, cur2};
                    stack.push(arr);
                }
                cur1++;
            } else if (c3 == c2) {
                cur2++;
            } else {
                if (stack.empty())
                    return false;
                else {
                    int[] arr = stack.pop();
                    i = arr[0];
                    cur1 = arr[1];
                    cur2 = arr[2]+1;
                }
            }
        }
        return true;
    }
}
