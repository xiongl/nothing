package mine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 8/25/13
 * Time: 2:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class SubStringConcatOfAllWords {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (L==null || L.length==0)
            return result;
        int len = L[0].length();
        ArrayList<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();

        for (int i=0; i<len && i+len*L.length<=S.length(); i++) {
            ArrayList<String> list = new ArrayList<String>();
            for (int j=0; j+i<=S.length()-len; j+=len) {
                list.add(S.substring(i+j, i+j+len));
            }
            lists.add(list);
        }
        HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
        HashMap<String, Integer> firstMeetMap = new HashMap<String, Integer>();
        for (String str : L) {
            if(wordMap.containsKey(str)) {
                wordMap.put(str, wordMap.get(str)+1);
            } else {
                wordMap.put(str, 1);
            }
            firstMeetMap.put(str, -1);
        }
        for (int j=0; j<lists.size(); j++) {
            ArrayList<String> list = lists.get(j);
            HashMap<String, Integer> words = new HashMap<String, Integer>(wordMap);
            HashMap<String, Integer> firstMeets = new HashMap<String, Integer>(firstMeetMap);
            for (int i=0; i<list.size(); i++) {
                String str = list.get(i);
                if(words.containsKey(str)) {
                    if (words.get(str) == 1)
                        words.remove(str);
                    else
                        words.put(str, words.get(str)-1);
                    if (firstMeets.containsKey(str) && firstMeets.get(str)==-1)
                        firstMeets.put(str, i);
                    if (words.size()==0) {
                        result.add((i-L.length+1)*len+j);
                        words.put(list.get(i-L.length+1), 1);
                        firstMeets.put(list.get(i-L.length+1), -1);
                    }
                } else {
                    if (firstMeets.containsKey(str)) {
                        i=firstMeets.get(str);
                    }
                    words = new HashMap<String, Integer>(wordMap);
                    firstMeets = new HashMap<String, Integer>(firstMeetMap);
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        new SubStringConcatOfAllWords().findSubstring("abaababbaba", new String[]{"ba","ab","ab"});
    }
}
