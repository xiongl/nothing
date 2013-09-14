package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 9/13/13
 * Time: 1:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (matrix==null || matrix.length<2)
            return;
        int n = matrix.length;
        for (int i=1; i<=(n+1)/2; i++) {
            for (int j=1; j<=n/2; j++) {
                if (i==j && i+j==n+1)
                    continue;
                int x = i;
                int y = j;
                int curr = matrix[x-1][y-1];
                while (true) {
                    int targetX = y;
                    int targetY = n+1-x;
                    int target = matrix[targetX-1][targetY-1];
                    matrix[targetX-1][targetY-1] = curr;
                    curr = target;
                    x = targetX;
                    y = targetY;
                    if (x==i && y==j)
                        break;
                }
            }
        }
    }
    public static void main(String[] args) {
        new RotateImage().rotate(new int[][] {{1,2},{3,4}});
    }
}
