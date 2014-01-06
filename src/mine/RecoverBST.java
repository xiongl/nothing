package mine;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 12/25/13
 * Time: 10:53 AM
 * To change this template use File | Settings | File Templates.
 */
public class RecoverBST {
    TreeNode pre;
    TreeNode first;
    TreeNode second;
    public void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        if(pre == null){
            pre = root;
        }else{
            if(pre.val > root.val){
                if(first == null){
                    first = pre;
                }
                second = root;
            }
            pre = root;
        }
        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        pre = null;
        first = null;
        second = null;
        inorder(root);
        if(first!=null && second!=null){
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }
}
