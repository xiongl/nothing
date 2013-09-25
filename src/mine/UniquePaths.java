package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 9/25/13
 * Time: 10:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] result = new int[m][n];
        int i=0, j=0;
        for (;i<m; i++) result[i][0]=1;
        for (;j<n; j++) result[0][j]=1;
        i=1; j=1;
        while (i<m) {
            while (j<n) {
                if (result[i][j] == 0)
                    result[i][j] = result[i-1][j] + result[i][j-1];
                j++;
            }
            i++;
            j=1;
        }
        return result[m-1][n-1];
    }
    public static void main(String[] args) {
        new UniquePaths().uniquePaths(3,3);
    }
}
