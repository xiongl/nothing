package theirs;

/**
 * Created with IntelliJ IDEA.
 * User: Xiong
 * Date: 13-12-17
 * Time: 下午8:59
 * To change this template use File | Settings | File Templates.
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1+len2 != s3.length())
            return false;
        if (len1 == 0)
            return s2.equals(s3);
        if (len2 == 0)
            return s1.equals(s3);
        boolean[][] match = new boolean[len1+1][len2+1];
        for (int i=0; i<len1; i++) {
            char c1 = s1.charAt(i);
            char c3 = s3.charAt(i);
            match[i+1][0] = c1 == c3 ? true : false;
        }
        for (int j=0; j<len2; j++) {
            char c2 = s2.charAt(j);
            char c3 = s3.charAt(j);
            match[0][j+1] = c2 == c3 ? true : false;
        }
        for (int i=1; i<=len1; i++) {
            char c1 = s1.charAt(i-1);
            for (int j=1; j<=len2; j++) {
                char c2 = s2.charAt(j-1);
                char c3 = s3.charAt(i+j-1);
                match[i][j] = (c1==c3 && match[i-1][j]) || (c2==c3 && match[i][j-1]);
            }
        }
        return match[len1][len2];
    }
    public static void main(String[] args) {
        new InterleavingString().isInterleave("a", "b", "ab");
    }
}
