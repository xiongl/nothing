package mine;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: Xiong
 * Date: 14-1-5
 * Time: 下午9:30
 * To change this template use File | Settings | File Templates.
 */
public class BTreeLevelOrdTraversal2 {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return result;
        Queue<TreeNode> one = new LinkedList<TreeNode>();
        Queue<TreeNode> two = new LinkedList<TreeNode>();
        one.add(root);
        while (one.size()!=0 || two.size()!=0) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            while (one.size() != 0) {
                TreeNode node = one.remove();
                if (node.left != null)
                    two.add(node.left);
                if (node.right != null)
                    two.add(node.right);
                list.add(node.val);
            }
            result.add(0, list);
            one = two;
            two = new LinkedList<TreeNode>();
        }
        return result;
    }
}
