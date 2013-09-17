package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 9/15/13
 * Time: 9:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class JumpGame {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A==null || A.length<2)
            return true;
        int len = A.length;
        int i = 0;
        while (i<len) {
            if (i+A[i]>=len-1)
                return true;
            if (A[i]==0)
                return false;
            int max = 0;
            int curr = i;
            for (int j=i+1; j<=i+A[i]; j++) {
                if (j+A[j] > max) {
                    max = j+A[j];
                    curr = j;
                }
            }
            i = curr;
        }
        return false;
    }
    public static void main(String[] args) {
        new JumpGame().canJump(new int[]{1,0,2});
    }
}
