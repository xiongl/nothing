package mine;

/**
 * Created with IntelliJ IDEA.
 * User: Xiong
 * Date: 14-7-13
 * Time: 下午9:48
 * To change this template use File | Settings | File Templates.
 */
public class PalindromePartitionTwo {
    public int minCut(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i=0; i<len; i++)
            dp[i][i] = 0;
        for (int j=1; j<len; j++) {
            for (int i=j-1; i>=0; i--) {
                if (s.charAt(i) == s.charAt(j) && (j-i<=2 || dp[i+1][j-1]==0)) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = 1 + ( dp[i][j-1] > dp[i+1][j] ? dp[i+1][j] : dp[i][j-1] );
                }
            }
        }
        return dp[0][len-1];
    }
    public static void main(String[] args) {
        System.out.println(new PalindromePartitionTwo().minCut("ababbbabbaba"));
    }
}
