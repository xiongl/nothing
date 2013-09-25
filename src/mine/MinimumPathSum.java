package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 9/25/13
 * Time: 3:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (grid==null || grid.length==0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (i==0 && j==0)
                    continue;
                int up = i > 0 ? grid[i-1][j] : Integer.MAX_VALUE;
                int left = j > 0 ? grid[i][j-1] : Integer.MAX_VALUE;
                grid[i][j] += (left > up ? up : left);
            }
        }
        return grid[m-1][n-1];
    }
    public static void main(String[] args) {
        new MinimumPathSum().minPathSum(new int[][]{{1,2},{1,1}});
    }
}
