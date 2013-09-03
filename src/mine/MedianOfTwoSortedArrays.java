package mine;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        // Start typing your code here...
        System.out.println("Hello world!");
        Solution sol = new Solution();
        System.out.println(sol.findMedianSortedArrays(new int[]{}, new int[]{2,3}));

    }
}

class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int lenA = A.length;
        int lenB = B.length;
        int mid = (lenA + lenB + 1) / 2 - 1;
        boolean twoMid = false;
        if ((lenA + lenB) % 2 == 0)
            twoMid = true;
        int curr = -1;
        int midOne = 0, midTwo = 0;
        if (lenA == 0) {
            midOne = B[mid];
            if (lenB > 1)
                midTwo = B[mid + 1];
        } else if (lenB == 0) {
            midOne = A[mid];
            if (lenA > 1)
                midTwo = A[mid + 1];
        } else {
            for (int i = 0, j = 0; curr < mid + 1; ) {
                curr++;
                midOne = midTwo;
                if (i == lenA ) {
                    midTwo = B[j];
                    j++;
                    continue;
                }
                if (j == lenB ) {
                    midTwo = A[i];
                    i++;
                    continue;
                }
                if (A[i] >= B[j]) {
                    midTwo = B[j];
                    j++;
                    continue;
                }

                if (B[j] >= A[i]) {
                    midTwo = A[i];
                    i++;
                    continue;
                }
            }
        }
        if (twoMid)
            return (double)(midOne + midTwo) / 2;
        else
            return midOne;
    }
}