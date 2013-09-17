package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 9/15/13
 * Time: 10:37 AM
 * To change this template use File | Settings | File Templates.
 */
public class MaxSubArray {
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A==null || A.length==0)
            return 0;
        int max = A[0];
        int sum = 0;
        for (int i=0; i<A.length; i++) {
            sum += A[i];
            if (sum > max){
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
