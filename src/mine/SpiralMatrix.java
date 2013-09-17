package mine;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 9/15/13
 * Time: 12:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class SpiralMatrix {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (matrix == null || matrix.length==0 || matrix[0].length==0)
            return list;
        int m = matrix.length-1;
        int n = matrix[0].length-1;
        int p = 0;
        int q = 0;
        while (p<=m && q<=n) {
            for (int i=q; i<=n; i++)
                list.add(matrix[p][i]);
            for (int i=p+1; i<=m; i++)
                list.add(matrix[i][n]);
            for (int i=n-1; i>=q && p<m; i--)
                list.add(matrix[m][i]);
            for (int i=m-1; i>=p+1 && q<n; i--)
                list.add(matrix[i][q]);
            p++; q++; m--; n--;
        }
        return list;
    }
    public static void main(String[] args) {
        new SpiralMatrix().spiralOrder(new int[][] {{1,2},{3,4}});
    }
}
