package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 9/26/13
 * Time: 1:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n<1)
            return 0;
        if (n==1)
            return 1;
        if (n==2)
            return 2;
        int one = 1;
        int two = 2;
        int step = 3;
        int result = 3;
        while (step<=n) {
            result = one + two;
            one = two;
            two = result;
            step ++;
        }
        return result;
    }
}
