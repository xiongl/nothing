package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 8/12/13
 * Time: 2:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        new ContainerWithMostWater().maxArea(new int[]{1,2, 4, 3});
    }

    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max = 0;
        int left = 0;
        for (int i=0; i<height.length; i++ ) {
            if(height[i] <= left) {
                continue;
            }
            left = height[i];
            int right = 0;
            for (int j=height.length-1; j>i; j--) {
                if(height[j] <= right) {
                    continue;
                }
                right = height[j];
                int area = (j-i) * (height[i] >= height[j] ? height[j] : height[i]);
                if (area > max)
                    max = area;
            }
        }
        return max;
    }
}
