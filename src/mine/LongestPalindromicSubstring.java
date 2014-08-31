package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 8/10/13
 * Time: 2:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        new LongestPalindromicSubstring().longestPalindrome("ccc");
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 0)
            return null;
        boolean[][] p = new boolean[len][len];
        String result = s.substring(0, 1);
        for (int i=len-1; i>=0; i--) {
            for (int j=i; j<len; j++) {
                if (j==i)
                    p[i][j] = true;
                else if (s.charAt(i) != s.charAt(j))
                    p[i][j] = false;
                else {
                    if (j==i+1)
                        p[i][j] = true;
                    else
                        p[i][j] = p[i+1][j-1];
                    if (p[i][j] && j-i+1 > result.length())
                        result = s.substring(i, j+1);
                }
            }
        }
        return result;
    }

}
