package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 10/6/13
 * Time: 3:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class SearchSortedArrayTwo {
    public boolean search(int[] A, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (A==null || A.length==0)
            return false;
        if (A.length == 1)
            return A[0]==target?true:false;
        boolean bigger = false;
        int curr = A[0];
        if (curr == target)
            return true;
        for (int i=1; i<A.length; i++) {
            if (A[i]==target)
                return true;
            if (A[i]<curr && bigger)
                return false;
            curr = A[i];
        }
        return false;
    }
}
