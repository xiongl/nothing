package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 12/27/13
 * Time: 12:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class PreorderInorderTraversal {
    private int[] pre;
    private int[] in;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = null;
        pre = preorder;
        in = inorder;

        return rec(0,  0, pre.length);
    }
    private TreeNode rec(int pStart, int iStart, int len) {
        if (len == 0)
            return null;
        TreeNode node = new TreeNode(pre[pStart]);
        int mid = iStart;
        for (int i=0; i<len; i++) {
            mid = iStart+i;
            if (in[mid] == pre[pStart])
                break;
        }
        if (mid != iStart) { // has left tree
            node.left =  rec(pStart+1, iStart, mid-iStart);
        }
        if (mid != iStart+len-1) { // has right tree
            node.right =  rec(pStart+mid-iStart+1, mid+1, len-mid+iStart-1);
        }
        return node;
    }
    public static void main(String[] args) {
        new PreorderInorderTraversal().buildTree(new int[]{1,2,3}, new int[]{1,2,3});
    }
}
