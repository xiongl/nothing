package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 10/6/13
 * Time: 4:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class RemoveDuplicatedFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ListNode curr = head;
        if (curr==null)
            return curr;
        while (curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}
