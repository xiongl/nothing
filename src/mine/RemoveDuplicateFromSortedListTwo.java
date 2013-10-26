package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 10/6/13
 * Time: 5:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class RemoveDuplicateFromSortedListTwo {
    public ListNode deleteDuplicates(ListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (head==null || head.next==null)
            return head;
        int lastVal = head.val;
        ListNode origin = head;
        while (head!=null) {
            if (head.next!=null && head.val==head.next.val) {
                lastVal = head.val;
                head = head.next.next;
            } else if (head.val==lastVal && head!=origin)
                head = head.next;
            else
                break;
        }
        if (head==null)
            return head;
        ListNode last = head;
        ListNode curr;
        lastVal = last.val;
        while (last.next!=null) {
            curr = last.next;
            if (curr.next!=null && curr.val==curr.next.val) {
                lastVal = curr.val;
                last.next = curr.next.next;
            } else if (curr.val == lastVal)
                last.next = last.next.next;
            else {
                lastVal = curr.val;
                last = last.next;
            }
        }
        return head;
    }
}
