package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 9/17/13
 * Time: 5:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s==null)
            return 0;
        int len = s.length()-1;
        int last = 0;
        while (len>=0) {
            if (s.charAt(len--)==' ') {
                if (last > 0)
                    return last;
            } else {
                last++;
            }
        }
        return last;
    }
}
