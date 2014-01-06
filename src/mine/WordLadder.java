package mine;

import java.util.HashSet;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 12/27/13
 * Time: 3:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class WordLadder {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        int len = 1;
        Stack<String> a = new Stack<String>();
        Stack<String> b = new Stack<String>();
        a.push(start);
        while (!a.empty() && dict.size()!=0) {
            while (!a.empty()) {
                String str = a.pop();
                if (str.equals(end))
                    return len;
                for (int i=0; i<str.length(); i++) {
                    for (char c='a'; c<='z'; c++) {
                        char[] arr = str.toCharArray();
                        if (arr[i] != c) {
                            arr[i] = c;
                            String tmp = new String(arr);
                            if (tmp.equals(end))
                                return len+1;
                            if (dict.contains(tmp)) {
                                b.push(tmp);
                                dict.remove(tmp);
                            }
                        }
                    }
                }
            }
            a = b;
            b = new Stack<String>();
            len++;
        }
        return 0;
    }
    public static void main(String[] args) {
        HashSet<String> dict = new HashSet<String>();
        String[] array = new String[]{"hot","cog","dog","tot","hog","hop","pot","dot"};
        for (String str : array) {
            dict.add(str);
        }
        new WordLadder().ladderLength("hot", "dog", dict);
    }
}
