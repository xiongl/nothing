package mine;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Xiong
 * Date: 13-9-25
 * Time: 下午10:24
 * To change this template use File | Settings | File Templates.
 */
public class TextJustification {
    public ArrayList<String> fullJustify(String[] words, int L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> strs = new ArrayList<String>();
        if (words==null || words.length==0)
            return strs;
        ArrayList<ArrayList<String>> lines = new ArrayList<ArrayList<String>>();
        int length = 0;
        ArrayList<String> line = new ArrayList<String>();
        lines.add(line);
        for (String word : words) {
            int len = word.length();
            if (length+len<=L) {
                line.add(word);
                length += (len+1);
            } else {
                line = new ArrayList<String>();
                line.add(word);
                lines.add(line);
                length = len + 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (ArrayList<String> list : lines) {
            if (list.size() == 1) {
                String str = list.get(0);
                sb.append(str);
                for(int i=0; i<L-str.length(); i++) {
                    sb.append(" ");
                }
                strs.add(sb.toString());
                sb = new StringBuilder();
            } else {
                int size = list.size();
                int strLen = 0;
                for (String str : list) {
                    strLen += str.length();
                }
                int blank = (L-strLen)/(size-1);
                int addBlank = (L-strLen)%(size-1);
                for (int i=0; i<size; i++) {
                    sb.append(list.get(i));
                    for (int j=0; j<blank; j++) {
                        sb.append(" ");
                    }
                    if (i<addBlank)
                        sb.append(" ");
                }
                strs.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return strs;
    }
    public static void main(String[] args) {
        new TextJustification().fullJustify(new String[]{"a","b","c","d","e"}, 1);
    }
}
