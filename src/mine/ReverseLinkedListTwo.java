package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 11/15/13
 * Time: 6:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReverseLinkedListTwo {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int i=1;
        ListNode first = head;
        ListNode start = new ListNode(0);
        start.next = head;
        head = start;
        while(i<m) {
            first = first.next;
            start = start.next;
            i++;
        }
        ListNode remain = first.next;
        ListNode last = first;
        while (i<n) {
            ListNode tmp = first;
            first = remain;
            remain = first.next;
            first.next = tmp;
            i++;
        }
        start.next = first;
        last.next = remain;
        return head.next;
    }
}
