/**
 * Created with IntelliJ IDEA.
 * User: Xiong
 * Date: 13-8-28
 * Time: 下午10:22
 * To change this template use File | Settings | File Templates.
 */
public class SearchSortedArray {
    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A==null || A.length==0)
            return -1;
        if (A.length ==1 )
            return (A[0]==target) ? 0 : -1;
        int i;
        if (A[0]==target) {
            return 0;
        } else if (A[0] < target) {
            i = 1;
            while (i<A.length-1 && A[i]!=target) {
                i++;
                if (A[i] > target || A[i] <= A[0])
                    return -1;
            }
        } else {
            i = A.length-1;
            while (i>0 && A[i]!=target) {
                i--;
                if (A[i] < target || A[i] >= A[0])
                    return -1;
            }
        }
        if (A[i]==target)
            return i;
        else
            return -1;
    }
}
