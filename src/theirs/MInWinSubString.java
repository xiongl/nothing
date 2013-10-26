package theirs;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 9/30/13
 * Time: 10:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class MInWinSubString {
    public String minWindow(String S, String T) {
        int minWindowStart = -1;
        int minWindowEnd = -1;

        if (T == null || T.length() == 0) return T;
        if (S == null) return S;

        int[] needsToFind = new int[256];
        int[] hasFound = new int[256];

        for (int i = 0; i < T.length(); i++) {
            needsToFind[T.charAt(i) - '0']++;
        }
        int minLength = Integer.MAX_VALUE;
        int count = 0;
        int begin = 0;
        for (int i = 0; i < S.length(); i++) {
            if (needsToFind[S.charAt(i) - '0'] ==0) continue;
            hasFound[S.charAt(i) - '0']++;

            if (hasFound[S.charAt(i) - '0'] <= needsToFind[S.charAt(i) - '0']) {
                count++;
            }

            if (count == T.length()) {
                while (needsToFind[S.charAt(begin) - '0'] ==0 ||
                        hasFound[S.charAt(begin) - '0'] > needsToFind[S.charAt(begin) - '0']) {
                    if (hasFound[S.charAt(begin) - '0'] > needsToFind[S.charAt(begin) - '0']) {
                        hasFound[S.charAt(begin) - '0']--;
                    }
                    begin++;
                }
                int tempLength = i - begin + 1;
                if (minLength > tempLength) {
                    minWindowStart = begin;
                    minWindowEnd = i;
                    minLength = tempLength;
                }
            }

        }

        if (minWindowStart == -1) {
            return "";
        }
        return S.substring(minWindowStart, minWindowEnd + 1);
    }
    public static void main(String[] args) {
        new MInWinSubString().minWindow("of_characters_and_as","aas");
    }
}
