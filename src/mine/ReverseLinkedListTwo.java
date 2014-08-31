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
        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode last = prev;
        for (int i=2; i<=m; i++) {
            last = last.next;
        }
        ListNode front = last.next;
        ListNode tail = last.next;
        ListNode next = last.next.next;
        ListNode temp;
        for (int i=m+1; i<=n; i++) {
            temp = next;
            next = next.next;
            temp.next = front;
            front = temp;
        }
        last.next = front;
        tail.next = next;
        return prev.next;
    }
    public static void main(String[] args) {
        ListNode first = new ListNode(3);
        ListNode sec = new ListNode(5);
        ListNode third = new ListNode(3);
        first.next=sec;
        //sec.next=third;
        new ReverseLinkedListTwo().reverseBetween(first,1,2);
    }
}
