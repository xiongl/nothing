package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 8/24/13
 * Time: 10:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A==null || A.length==0)
            return 0;
        int curr = A[0];
        int count = 1;
        for(int i=1; i<A.length; i++) {
            if (A[i] != curr) {
                count++;
                curr = A[i];
                A[count-1] = curr;
            }
        }
        return count;
    }
}
