package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 9/29/13
 * Time: 5:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class SortColors {
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A==null)
            return;
        int forRed=0;
        int forBlue=A.length-1;
        for (int i=0; i<=forBlue; ) {
            if (A[i]==0) {
                if (i!=forRed) {
                    A[i]=A[forRed];
                    A[forRed]=0;
                } else {
                    i++;
                }
                forRed++;
            } else if (A[i]==2) {
                if (i!=forBlue) {
                    A[i]=A[forBlue];
                    A[forBlue]=2;
                } else {
                    i++;
                }
                forBlue--;
            } else {
                i++;
            }
        }
    }
    public static void main(String[] args) {
        new SortColors().sortColors(new int[]{1,0});
    }
}
