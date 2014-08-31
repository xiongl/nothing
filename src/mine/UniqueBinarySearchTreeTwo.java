package mine;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Xiong
 * Date: 13-12-15
 * Time: 下午12:26
 * To change this template use File | Settings | File Templates.
 */
public class UniqueBinarySearchTreeTwo {
    public ArrayList<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }
    private ArrayList<TreeNode> dfs(int start, int end) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if (start > end)
            result.add(null);
        for (int i=start; i<=end; i++) {
            ArrayList<TreeNode> leftList = dfs(start, i-1);
            ArrayList<TreeNode> rightList = dfs(i+1, end);
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
