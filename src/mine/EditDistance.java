package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 9/27/13
 * Time: 4:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (word1==null && word2==null)
            return 0;
        if (word1==null)
            return word2.length();
        if (word2==null)
            return word1.length();

        int len1 = word1.length()+1;
        int len2 = word2.length()+1;
        int[][] dp = new int[len1][len2];
        for (int i=0; i<len1; i++) {
            dp[i][0] = i;
        }
        for (int j=1; j<len2; j++) {
            dp[0][j] = j;
        }
        for (int i=1; i<len1; i++) {
            char ch1 = word1.charAt(i-1);
            for (int j=1; j<len2; j++) {
                char ch2 = word2.charAt(j-1);
                if (ch1 == ch2) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int change = dp[i-1][j-1]+1;
                    int delete = dp[i-1][j]+1;
                    int add = dp[i][j-1]+1;
                    int best = change > delete ? delete : change;
                    best = best > add ? add : best;
                    dp[i][j] = best;
                }
            }
        }
        return dp[len1-1][len2-1];
    }

    public static void main(String[] args) {
        new EditDistance().minDistance("b", "");
    }
}
