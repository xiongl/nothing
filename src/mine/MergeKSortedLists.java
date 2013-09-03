package mine;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 8/21/13
 * Time: 5:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (lists==null||lists.size()==0)
            return null;
        if (lists.size()==1)
            return lists.get(0);
        ListNode result = lists.get(0);
        for (int i=1; i<lists.size(); i++) {
            result = mergeTwo(result, lists.get(i));
        }
        return result;
    }

    public ListNode mergeTwo(ListNode mergeTo, ListNode mergeFrom) {
        if (mergeTo == null) {
            return mergeFrom;
        }
        ListNode head = new ListNode(Integer.MIN_VALUE);
        head.next = mergeTo;
        ListNode curr = head;
        while (mergeFrom != null) {
            while (curr.next.val < mergeFrom.val) {
                curr = curr.next;
                if (curr.next==null) {
                    curr.next = mergeFrom;
                    return head.next;
                }
            }

            ListNode temp = mergeFrom.next;
            mergeFrom.next = curr.next;
            curr.next = mergeFrom;
            mergeFrom = temp;

        }
        return head.next;
    }
    public static void main(String[] args) {
        ArrayList<ListNode> lists = new ArrayList<ListNode>();
        lists.add(null);
        lists.add(new ListNode(-2));
        ListNode node1 = new ListNode(-3);
        ListNode node2 = new ListNode(-2);
        ListNode node3 = new ListNode(1);
        node1.next=node2;
        node2.next=node3;
        lists.add(node1);
        new MergeKSortedLists().mergeKLists(lists);
    }
}



