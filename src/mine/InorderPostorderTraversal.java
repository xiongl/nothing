package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 12/27/13
 * Time: 2:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class InorderPostorderTraversal {
    private int[] in;
    private int[] post;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        in = inorder;
        post = postorder;
        return rec(0, 0, in.length);
    }
    private TreeNode rec(int is, int ps, int len) {
        if (len == 0)
            return null;
        TreeNode node = new TreeNode(post[ps+len-1]);
        int i = 0;
        for (; i<len; i++) {
            if (in[is + i] == post[ps+len-1])
                break;
        }
        if (i != 0) {
            node.left = rec(is, ps, i);
        }
        if (i != len-1) {
            node.right = rec(is+i+1, ps+i, len-i-1);
        }
        return node;
    }
    public static void main(String[] args) {
        new InorderPostorderTraversal().buildTree(new int[]{1,2,3}, new int[]{3,2,1}) ;
    }
}
