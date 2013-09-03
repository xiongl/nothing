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
        new LongestPalindromicSubstring().longestPalindrome("abb");
    }

    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = s.length();
        if (len == 0)
            return "";
        if (len == 1)
            return s;
        boolean[][] dp = new boolean[len][len];
        int start = 0;
        int max = 1;
        for (int i = 0; i < len - 1; i++) {
            dp[i][i] = true;
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                max = 2;
                start = i;
            }
        }
        for (int i = 3; i <= len; i++) {
            for (int j = 0; j < len - i + 1; j++) {
                int k = j + i - 1;
                if (s.charAt(j) == s.charAt(k) && dp[j + 1][k - 1]) {
                    dp[j][k] = true;
                    max = i;
                    start = j;
                }
            }
        }
        return s.substring(start, start+max);
    }

}
