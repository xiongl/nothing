package mine;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 8/21/13
 * Time: 10:40 AM
 * To change this template use File | Settings | File Templates.
 */
public class GenerateParenthesis {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<String>();
        recursivePrint(n, n, sb, list);
        return list;
    }

    private void recursivePrint(int left, int right, StringBuilder sb, ArrayList<String> list) {
        if (left==0 && right==0) {
            list.add(sb.toString());
        }
        if (left > 0) {
            sb.append("(");
            recursivePrint(left-1, right, sb, list);
        }
        if (left < right) {
            sb.append(")");
            recursivePrint(left, right-1, sb, list);
        }
        if (sb.length() > 0)
            sb.delete(sb.length()-1, sb.length());
    }

    public static void main(String[] args) {
        new GenerateParenthesis().generateParenthesis(1);
    }
}
