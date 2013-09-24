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
        // Start typing your Java solution below
        // DO NOT write main() function
        int permut = 1;
        char[] arr = new char[n];
        for (int i=1; i<=n; i++) {
            permut *= i;
            arr[i-1] = (char)('0'+i);
        }
        int m = 0;
        k--;
        permut /= n;
        while (m<n-1 && k>0) {
            int index = k / permut;
            k = k % permut;
            if (index > 0) {
                char temp = arr[m+index];
                for (int j=index; j>=1; j--) {
                    arr[m+j] = arr[m+j-1];
                }
                arr[m] = temp;
            }
            permut /= (n-1-m);
            m++;
        }
        return new String(arr);
    }
    public static void main(String[] args) {
        new PermutationSequence().getPermutation(3,5);
    }
}
