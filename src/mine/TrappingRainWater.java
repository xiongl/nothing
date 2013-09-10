package mine;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Xiong
 * Date: 13-9-10
 * Time: 下午10:23
 * To change this template use File | Settings | File Templates.
 */
public class TrappingRainWater {
    public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null)
            return 0;
        int len = A.length;
        int vol = 0;
        int last = 0;
        int curr;
        Stack<int[]> stack = new Stack<int[]>();
        for (int i=0; i<len; i++) {
            curr = A[i];
            if (curr < last) {
                stack.push(new int[]{last, curr, i});
            } else if (curr > last) {
                while (!stack.empty()) {
                    int[] arr = stack.pop();
                    int high = arr[0] > curr ? curr : arr[0];
                    int low = arr[1] > last ? arr[1] : last;
                    vol = vol + (high-low)*(i-arr[2]);
                    if (curr < arr[0]) {
                        stack.push(new int[] {arr[0], high, arr[2]});
                        break;
                    }
                }
            }
            last = curr;
        }
        return vol;
    }
    public static void main(String[] args) {
        new TrappingRainWater().trap(new int[]{4,2,0,3,2,5});
    }
}
