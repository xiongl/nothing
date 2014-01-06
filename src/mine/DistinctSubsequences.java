package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 1/6/14
 * Time: 5:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class DistinctSubsequences {
    public int numDistinct(String S, String T) {
        if (S==null || T==null || S.length()==0 || T.length()==0)
            return 0;
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        return findDistinct(s, t, 0, 0);
    }
    private int findDistinct(char[] s, char[] t, int startS, int indexT) {
        int num = 0;
        char target = t[indexT];
        for (int i=startS; i<s.length; i++) {
            if (s[i] == target) {
                if (indexT==t.length-1) {
                    num++;
                } else if (s.length-i >= t.length-indexT) {
                    num += findDistinct(s, t, i+1, indexT+1);
                }
            }
        }
        return num;
    }
}
