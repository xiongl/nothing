package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 8/10/13
 * Time: 2:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode result = new ListNode(0);
        ListNode empty = new ListNode(0);
        ListNode curr = result;
        ListNode next;
        int ten = 0;
        int sum = 0;
        while(true) {
            sum = (l1.val + l2.val + ten);
            ten = sum / 10;
            curr.val = sum % 10;
            if (l1.next==null && l2.next==null && ten==0)
                break;
            next = new ListNode(0);
            curr.next = next;
            curr = next;
            l1 = l1.next!=null ? l1.next : empty;
            l2 = l2.next!=null ? l2.next : empty;
        }
        return result;
    }
}

