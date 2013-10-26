package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 9/29/13
 * Time: 11:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean firstRow = false;
        boolean firstCol = false;
        for (int i=0; i<matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstCol = true;
                break;
            }
        }
        for (int j=0; j<matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                firstRow = true;
                break;
            }
        }
        for (int i=1; i<matrix.length; i++) {
            for (int j=1; j<matrix[i].length; j++){
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i=1; i<matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j=1; j<matrix[i].length; j++) {
                    matrix[i][j] = 0 ;
                }
            }
        }
        for (int j=1; j<matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                for (int i=1; i<matrix.length; i++) {
                    matrix[i][j] = 0 ;
                }
            }
        }
        if (firstRow) {
            for (int j=0; j<matrix[0].length; j++) {
                matrix[0][j] = 0 ;
            }
        }
        if (firstCol) {
            for (int i=0; i<matrix.length; i++) {
                matrix[i][0] = 0 ;
            }
        }
    }
    public static void main(String[] args) {
        new SetMatrixZeros().setZeroes(new int[][]{{0,1}});

    }
}
