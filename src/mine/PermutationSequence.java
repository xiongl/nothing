package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 9/24/13
 * Time: 10:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        char[] c = new char[n];
        int p=1;
        for (int i=1 ; i<=n; i++) {
            c[i-1] = (char) (i+'0');
            p *= i;
        }
        int d = 0;
        p /= n;
        k--;
        char t;
        for (int i=0; i<=n-2 && k>0; i++) {
            d = k / p;
            k = k - d*p;
            if (d >= 1) {
                t = c[i+d];
                for (int j=d; j>=1; j--) {
                    c[i+j] = c[i+j-1];
                }
                c[i] = t;
            }
            p /= n-1-i;
        }
        return new String(c);
    }
    public static void main(String[] args) {
        new PermutationSequence().getPermutation(3,5);
    }
}
