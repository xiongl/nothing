package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 10/26/13
 * Time: 11:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (head == null)
            return head;
        ListNode pivotal = new ListNode(x);
        ListNode pivCurr = pivotal;
        while (head != null) {
            if (head.val < x) {
                break;
            } else {
                pivCurr.next = head;
                head = head.next;
                pivCurr = pivCurr.next;
                pivCurr.next = null;
            }
        }
        if (head == null)
            return pivotal.next;
        ListNode current = head;
        while (current.next != null) {
            if (current.next.val < x) {
                current = current.next;
            } else {
                pivCurr.next = current.next;
                current.next = current.next.next;
                pivCurr = pivCurr.next;
                pivCurr.next = null;
            }
        }
        current.next = pivotal.next;
        return head;
    }
    public static void main(String[] args) {
        ListNode node = new ListNode(2);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        node.next = b;
        //b.next = c;
        new PartitionList().partition(node, 2);
    }
}
