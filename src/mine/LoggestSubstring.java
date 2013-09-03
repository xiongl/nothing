package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 8/9/13
 * Time: 10:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class LoggestSubstring {
    public static void main (String[] args) {
        System.out.println(new LoggestSubstring().lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s.length() == 0)
            return 0;
        int start = 0;
        int end = 1;
        int maxLen = 1;
        for (int i=1; i<s.length(); i++) {
            for (int j=start; j<end; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    start = j+1;
                    break;
                }
            }
            end++;
            if(end-start > maxLen) {
                maxLen = end - start;
            }
        }
        return maxLen;
    }
}




