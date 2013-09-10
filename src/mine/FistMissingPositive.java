package mine;

/**
 * Created with IntelliJ IDEA.
 * User: Xiong
 * Date: 13-9-10
 * Time: 下午8:23
 * To change this template use File | Settings | File Templates.
 */
public class FistMissingPositive {
    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null)
            return 1;
        int len = A.length;
        if (len == 0)
            return 1;
        int i = 0;
        while (i < len) {
            int val = A[i];
            if(val>0 && val!=i+1 && val<len && A[val-1]!=val) {
                A[i] = A[val-1];
                A[val-1] = val;
            } else {
                i++;
            }
        }
        for (int j=0; j<len; j++) {
            if (j+1 != A[j])
                return j+1;
        }
        return A.length+1;
    }
    public static void main(String[] args) {
        new FistMissingPositive().firstMissingPositive(new int[]{1,1});
    }
}
