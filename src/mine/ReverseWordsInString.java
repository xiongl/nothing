package mine;

/**
 * Created with IntelliJ IDEA.
 * User: Xiong
 * Date: 14-7-20
 * Time: 下午4:03
 * To change this template use File | Settings | File Templates.
 */
public class ReverseWordsInString {
    public String reverseWords(String s) {
        if (s==null)
            return null;
        int len = s.length();
        if (len==0)
            return s;
        StringBuffer sb = new StringBuffer();
        int end=len;
        int start = end-1;
        for(;start>=0;start--) {
            if (s.charAt(start)==' ') {
                if (end-1==start)
                    end--;
                else {
                    sb.append(s.substring(start+1, end));
                    sb.append(" ");
                    end = start;
                }
            }
        }
        if (start<end-1) {
            sb.append(s.substring(start+1, end));
        } else if (sb.length()>0){
            sb.delete(sb.length()-1, sb.length());
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        new ReverseWordsInString().reverseWords(" 1");
    }
}
