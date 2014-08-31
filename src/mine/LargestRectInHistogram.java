package mine;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 10/6/13
 * Time: 9:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class LargestRectInHistogram {
    public int largestRectangleArea(int[] height) {
        if (height == null)
            return 0;
        int len = height.length;
        if (len == 0)
            return 0;
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i=0; i<=len; ) {
            int temp = 0 ;
            if (i<=len-1)
                temp = height[i];
            if (stack.empty() || height[stack.peek()] < temp) {
                stack.push(i++);
            }
            else {
                int left = stack.pop();
                int width = i - (stack.empty() ? 0 : stack.peek()+1) ;
                int area = height[left] * width;
                max = max > area ? max : area;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        new LargestRectInHistogram().largestRectangleArea(new int[]{4,2});
    }
}
