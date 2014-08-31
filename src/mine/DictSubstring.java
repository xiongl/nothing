package mine;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Xiong
 * Date: 14-7-8
 * Time: 下午10:08
 * To change this template use File | Settings | File Templates.
 */
public class DictSubstring {
    public int calculate(String word, Set<String> dict) {
        return cal(word, 0, dict);
    }

    private int cal(String word, int start, Set<String> dict) {
        if (start == word.length())
            return 1;
        int count = 0;
        for (int i=start+1; i<=word.length(); i++) {
            if (dict.contains(word.substring(start, i)))
                count += cal(word, i, dict);
        }
        return count;
    }

    public int dp(String word, Set<String> dict) {
        int len = word.length();
        int[] count = new int[len+1];
        count[0]=1;
        for (int i=0; i<len; i++) {
            for (int j=0; j<=i; j++) {
                String sub = word.substring(j, i+1);
                if (count[j]!=0 && dict.contains(sub))
                    count[i+1] += count[j];
            }
        }
        return count[len];
    }

    public static void main(String[] args) {
        Set<String> dict = new HashSet<String>();
        dict.add("a");
        dict.add("an");
        dict.add("ave");
        dict.add("bar");
        dict.add("baron");
        dict.add("nave");
        dict.add("on");
        System.out.println(new DictSubstring().dp("anavebaron", dict));
    }
}
