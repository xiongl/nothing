package mine;

/**
 * Created with IntelliJ IDEA.
 * User: Xiong
 * Date: 13-11-13
 * Time: 下午10:17
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
    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode sec = new ListNode(2);
        ListNode third = new ListNode(3);
        first.next=sec;
        sec.next=third;
        new ReverseLinkedListTwo().reverseBetween(first,1,3);
    }
}
