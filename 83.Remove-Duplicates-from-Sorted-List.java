/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        // corner case 
        if (head==null || head.next==null)
            return head;
        
        ListNode node = head;
        int value = node.val;

        while (true) {
            
            if (node.next==null)
                break;
            
            if (value==node.next.val) {
                // remove the duplicate node
                node.next = node.next.next;
            } else {
                // assign the new value
                value = node.next.val;
                node = node.next;
            }
            
        }
        
        return head;
    }
}