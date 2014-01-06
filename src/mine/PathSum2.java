package mine;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 1/6/14
 * Time: 4:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class PathSum2 {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        rec(root, 0, sum, result, list);
        return result;
    }
    private void rec(TreeNode node, int cur, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list) {
        if (node == null)
            return;
        cur += node.val;
        ArrayList<Integer> newList = new ArrayList<Integer>(list);
        newList.add(node.val);
        if (node.left==null && node.right==null && cur==sum) {
            result.add(newList);
        }
        if (node.left != null) {
            rec(node.left, cur, sum, result, newList);
        }
        if (node.right != null) {
            rec(node.right, cur, sum, result, newList);
        }
    }
    public static void main(String[] args) {
        TreeNode node = new TreeNode(0);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        node.left = left;
        node.right = right;
        new PathSum2().pathSum(node, 1);
    }
}
