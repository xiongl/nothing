package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 8/15/13
 * Time: 10:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class LoggestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (strs.length == 0)
            return "";
        String first = strs[0];
        if (strs.length == 1)
            return first;
        String compare;
        int longest = first.length();
        for (int i=1; i<strs.length; i++) {
            if (longest == 0)
                return "";
            compare = strs[i];
            if (compare.length() == 0)
                return "";
            for (int j=0; j<longest; j++) {
                if (j==compare.length() || first.charAt(j) != compare.charAt(j)) {
                    longest = j;
                    continue;
                }
            }
        }
        return first.substring(0, longest);
    }
}
