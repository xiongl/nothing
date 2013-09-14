package theirs;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 9/13/13
 * Time: 1:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class JumpGameTwo {
    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A==null)
            return 0;
        int len = A.length;
        if (len < 2)
            return 0;
        int i = 0;
        int currMax = 0;
        int step = 1;
        while (i<len) {
            currMax = i + A[i];
            if (currMax >= len-1)
                return step;
            step++;
            int tempMax = 0;
            for (int j=i+1; j<=currMax; j++) {
                if (j+A[j] > tempMax) {
                    tempMax = j+A[j];
                    i=j;
                }
            }
        }
        return step;
    }
}
