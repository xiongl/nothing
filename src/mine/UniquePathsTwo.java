package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 9/25/13
 * Time: 1:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class UniquePathsTwo {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i=1, j=1;
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 0)
            obstacleGrid[0][0]=-1;
        else
            obstacleGrid[0][0]=0;
        for (;i<m; i++)
            if(obstacleGrid[0][i]!=1)
                obstacleGrid[0][i]=obstacleGrid[0][i-1];
            else
                obstacleGrid[0][i]=0;
        for (;j<n; j++)
            if(obstacleGrid[j][0]!=1)
                obstacleGrid[j][0]=obstacleGrid[j-1][0];
            else
                obstacleGrid[j][0]=0;
        i=1; j=1;
        while (i<m) {
            while (j<n) {
                if (obstacleGrid[j][i] == 0)
                    obstacleGrid[j][i] = obstacleGrid[j][i-1] + obstacleGrid[j-1][i];
                if (obstacleGrid[j][i] == 1)
                    obstacleGrid[j][i] = 0;
                j++;
            }
            i++;
            j=1;
        }
        return -obstacleGrid[n-1][m-1];
    }
    public static void main(String[] args) {
        new UniquePathsTwo().uniquePathsWithObstacles(new int[][]{{1,0}});
    }
}
