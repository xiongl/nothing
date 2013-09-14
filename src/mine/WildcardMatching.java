package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 9/12/13
 * Time: 2:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s==null || p==null)
            return false;
        int i = 0;
        int j = 0;
        boolean hasStar = false;
        int li = -1;
        int lj = -1;
        if (p.length()==0 && s.length()>0)
            return false;
        if (p.length()==1 && p.charAt(0)=='*')
            return true;
        while (j<p.length()) {
            if (i>=s.length() && p.charAt(j)!='*')
                return false;
            char ch = p.charAt(j);
            if (ch =='*') {
                li = i+1;
                lj = j+1;
                hasStar = true;
                j++;
            } else if (ch == '?') {
                i++;
                j++;
            } else {
                if (ch == s.charAt(i)) {
                    i++;
                    j++;
                } else {
                    if (!hasStar)
                        return false;
                    else {
                        i=li++;
                        j=lj;
                    }
                }
            }
            if (j==p.length()) {
                if (i==s.length())
                    return true;
                else if (!hasStar)
                    return false;
                else {
                    i=li++;
                    j=lj;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        new WildcardMatching().isMatch("a", "a*");
    }

}
