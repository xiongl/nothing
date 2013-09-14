package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 9/14/13
 * Time: 1:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class PowerXN {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        double result = 1;
        if (n==0)
            return result;
        if (n<0) {
            n = -n;
            x = 1/x;
        }
        double curr = x;
        while (n>0) {
            if (n%2==1) {
                result *= curr;
            }
            curr *= curr;
            n /= 2;
        }
        return result;
    }
}
