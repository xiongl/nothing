package mine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Xiong
 * Date: 13-9-25
 * Time: 下午10:24
 * To change this template use File | Settings | File Templates.
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int L) {
        List<List<String>> temp = new ArrayList<List<String>>();
        int currLen = 0;
        List<String> list = new ArrayList<String>();
        if (words.length>0)
            temp.add(list);
        for (String word : words) {
            if (currLen+word.length()>L) {
                list = new ArrayList<String>();
                temp.add(list);
                list.add(word);
                currLen = word.length()+1;
            } else {
                list.add(word);
                currLen += word.length()+1;
            }
        }
        List<String> result = new ArrayList<String>();
        for (List<String> li : temp) {
            result.add(printString(li, L));
        }
        return result;
    }

    private String printString(List<String> list, int L) {
        StringBuffer sb = new StringBuffer();
        if (list.size()==1) {
            String str = list.get(0);
            sb.append(str);
            for (int i=str.length(); i<L; i++) {
                sb.append(" ");
            }
            return sb.toString();
        }

        int strLen = 0;
        for (String str: list) {
            strLen += str.length();
        }
        int blankCount = (L-strLen)/(list.size()-1);
        int moreBlank = (L-strLen)%(list.size()-1);
        for (int i=0; i<list.size(); i++) {
            sb.append(list.get(i));
            if (i<list.size()-1) {
                for (int j=0; j<blankCount; j++) {
                    sb.append(" ");
                }
                if (i<moreBlank)
                    sb.append(" ");
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        new TextJustification().fullJustify(new String[]{"a","b","c","d","e"}, 3);
    }
}
