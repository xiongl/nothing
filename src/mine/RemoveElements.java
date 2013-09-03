package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 8/24/13
 * Time: 11:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class RemoveElements {
    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = A.length;
        for (int i=0; i<len; i++) {
            if (A[i] == elem) {
                while(A[len-1]==elem){
                    len--;
                    if (len==i)
                        return len;
                }
                A[i]=A[len-1];
                len--;
            }
        }
        return len;
    }
}
