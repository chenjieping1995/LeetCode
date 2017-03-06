/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if (head == null)   return head;
        if (head.next == null && n == 1)    return head.next;
        
        ListNode slow = head, fast = head;
        
        for (int i=0; i<n; i++){
            fast=fast.next;
        }
        
        if (fast == null)
            // 说明此时的n与链表长度相同
            return head.next;
        
        while (fast.next!=null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        if (slow.next.next != null) {
            slow.next = slow.next.next;
        } else {
            slow.next = null;
        }
        
        return head;
    }
}