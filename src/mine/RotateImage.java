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
        int n = matrix.length;
        int m = matrix[0].length;
        int temp;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<m; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m/2; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][m-1-j];
                matrix[i][m-1-j] = temp;
            }
        }
    }
    public static void main(String[] args) {
        new RotateImage().rotate(new int[][] {{1,2},{3,4}});
    }
}
