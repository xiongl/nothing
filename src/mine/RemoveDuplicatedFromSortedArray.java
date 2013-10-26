package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 10/3/13
 * Time: 2:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class RemoveDuplicatedFromSortedArray {
    public int removeDuplicates(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (A==null || A.length==0)
            return 0;
        int count = 1;
        int curr = A[0];
        boolean dup = false;
        int len = A.length;
        for (int i=1; i<len; ) {
            if (A[i]==curr) {
                if (!dup) {
                    dup = true;
                    count++;
                    i++;
                } else {
                    for (int j=i; j<len-1; j++) {
                        A[j] = A[j+1];
                    }
                    A[len-1] = 0;
                    len--;
                }
            } else {
                curr = A[i];
                count++;
                i++;
                dup = false;
            }
        }
        return count;
    }
}
