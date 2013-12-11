package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 10/31/13
 * Time: 3:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int a = m;
        int b = n;

        while (a>0 && b>0) {
            if (A[a-1]>B[b-1])
                A[a+b-1] = A[a---1];
            else
                A[a+b-1] = B[b---1];
        }
        for (int i=0; i<b; i++) {
            A[i] = B[i];
        }
    }
    public static void main(String[] args){
        int[] A = new int[2];
        A[0] = 1;
        new MergeSortedArray().merge(A, 1, new int[]{2}, 1);
    }
}
