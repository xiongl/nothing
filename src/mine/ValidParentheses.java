package mine;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 8/18/13
 * Time: 9:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack stack = new Stack();
        char ch;
        for (int i=0; i<s.length(); i++) {
            ch = s.charAt(i);
            if(ch=='(' || ch=='{' || ch=='[')
                stack.push(ch);
            if(ch==')')
                if (stack.size()==0 || (Character)stack.pop()!='(')
                    return false;
            if(ch=='}')
                if (stack.size()==0 || (Character)stack.pop()!='{')
                    return false;
            if(ch==']')
                if (stack.size()==0 || (Character)stack.pop()!='[')
                    return false;
        }
        if (stack.size()==0)
            return true;
        return false;
    }
    public static void main(String[] args) {
        new ValidParentheses().isValid("]");
    }
}
