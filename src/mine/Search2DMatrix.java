package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 9/29/13
 * Time: 3:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0;
        int right = n-1;
        int mid;
        int row;
        if (matrix[left][0]==target || matrix[right][0]==target)
            return true;
        if (matrix[right][0]<target)
            row = right;
        else {
            while (left < right-1) {
                mid = (left+right)/2;
                if (matrix[mid][0]==target)
                    return true;
                else if (matrix[mid][0]>target)
                    right = mid;
                else
                    left = mid;
            }
            row = left;
        }

        left = 0;
        right = m-1;
        if (matrix[row][left]==target || matrix[row][right]==target)
            return true;
        while (left < right-1) {
            mid = (left+right)/2;
            if (matrix[row][mid]==target)
                return true;
            else if (matrix[row][mid]>target)
                right = mid;
            else
                left = mid;
        }
        return false;
    }

    public static void main(String[] args){
        new Search2DMatrix().searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}}, 30);
    }
}
