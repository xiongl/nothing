package mine;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Xiong
 * Date: 13-12-10
 * Time: 下午10:21
 * To change this template use File | Settings | File Templates.
 */
public class InOrderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root != null)
            stack.push(root);
        TreeNode node, temp;
        while (!stack.empty()) {
            node = stack.peek();
            while (node.left!=null) {
                stack.push(node.left);
                temp = node.left;
                node.left = null;
                node = temp;
            }
            if (node.right!=null) {
                stack.push(node.right);
                node.right = null;
                continue;
            }
            list.add(stack.pop().val);
        }
        return list;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        new InOrderTraversal().inorderTraversal(root);
    }
}
