package mine;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 9/14/13
 * Time: 12:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Anagrams {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> list = new ArrayList<String>();
        if (strs==null || strs.length<2)
            return list;
        HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
        for (int i=0; i<strs.length; i++) {
            char[] array = strs[i].toCharArray();
            Arrays.sort(array);
            String str = String.valueOf(array);
            if (map.containsKey(str)) {
                map.get(str).add(i);
            } else {
                ArrayList<Integer> li = new ArrayList<Integer>();
                li.add(i);
                map.put(str, li);
            }
        }
        for (ArrayList<Integer> lis : map.values()) {
            if (lis.size()<=1)
                continue;
            for (Integer index : lis) {
                list.add(strs[index]);
            }
        }
        return list;
    }
}
