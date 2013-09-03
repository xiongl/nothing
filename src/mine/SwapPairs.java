package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 8/21/13
 * Time: 5:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head==null || head.next==null)
            return head;
        ListNode result = new ListNode(0);
        result.next = head;
        head = result;
        while (head.next!=null && head.next.next!=null) {
            ListNode temp = head.next;
            head.next = head.next.next;
            temp.next = head.next.next;
            head.next.next = temp;
            head = head.next.next;
        }
        return result.next;
    }
}
