package mine;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 9/12/13
 * Time: 4:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class JumpGameTwo {
    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A==null)
            return 0;
        int len = A.length;
        if (len < 2)
            return 0;
        int step = 1;
        Stack<Integer> one = new Stack<Integer>();
        Stack<Integer> two = new Stack<Integer>();
        one.push(0);
        Stack<Integer> from = one;
        Stack<Integer> to = two;
        while (true) {
            while (!from.empty()) {
                int curr = from.pop();
                for (int i=1; i<=A[curr]; i++) {
                    if (curr+i == len-1)
                        return step;
                    to.push(curr+i);
                    if (curr-i>0)
                        to.push(curr-i);
                }
            }
            step++;
            if (step%2==1) {
                from = one;
                to = two;
            } else {
                from = two;
                to = one;
            }
        }
    }

    public static void main(String[] args) {
        new JumpGameTwo().jump(new int[]{1,1,1,1,1});
    }
}
