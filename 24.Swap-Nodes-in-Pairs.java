/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode x = newHead;
        while (x.next!=null && x.next.next!=null) {
            ListNode first = x.next;
            ListNode second = x.next.next;
            first.next = second.next;
            x.next = second;
            x.next.next = first;
            x = first;
        }
        return newHead.next;
    }
}