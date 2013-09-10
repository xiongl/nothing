/**
 * Created with IntelliJ IDEA.
 * User: Xiong
 * Date: 13-8-28
 * Time: 下午10:48
 * To change this template use File | Settings | File Templates.
 */
public class SearchRange {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A==null && A.length==0)
            return new int[]{-1, -1};

        int end = A.length-1;
        int start = 0;
        int left = -1;
        int right = -1;
        while (start <= end) {
            if (start==end)
                return A[start]==target ? new int[]{start, start} : new int[]{-1,-1};
            int mid = (start+end)/2;
            if (A[mid] > target) {
                end = mid;
            } else if (A[mid] < target) {
                start = mid+1;
            } else {
                left = mid;
                while (left>start && A[left-1]==target) {
                    left --;
                }
                right = mid;
                while (right<end && A[right+1]==target) {
                    right ++;
                }
                break;
            }
        }
        return new int[]{left, right};
    }
    public static void main(String[] args) {
        int[] result = new SearchRange().searchRange(new int[]{1,4}, 4);
        System.out.println(result);
    }
}
