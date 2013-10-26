package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 10/6/13
 * Time: 9:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class LargestRectInHistogram {
    public int largestRectangleArea(int[] height) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int len = height.length;
        int largest = 0;
        int size;
        int peak = 0;
        boolean hasPeak;
        int min;
        for (int i=0; i<len; i++) {
            min = height[i];
            hasPeak = false;
            for (int j=(peak>i?peak:i); j<len; j++) {
                if (height[j] < min)
                    min = height[j];
                if (j<len-1 && height[j+1]>=height[j])
                    continue;
                if (!hasPeak) {
                    hasPeak = true;
                    peak = j;
                }
                size = (j-i+1) * min;
                if (size > largest)
                    largest = size;
            }
        }
        return largest;
    }
    public static void main(String[] args) {
        new LargestRectInHistogram().largestRectangleArea(new int[]{2,0,2});
    }
}
