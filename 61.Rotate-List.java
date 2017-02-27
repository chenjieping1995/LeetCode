/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // 先用一个指针向后走到头,测量出链表的长度
        // len - k 即可得到需要移到尾部的结点个数
        // 多指针操作移动结点到尾部
        
        ListNode tail = head;
        
        if ((head == null) || (head.next == null))   return head;
        
        // 链表长度
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len ++;
        }
        
        ListNode newHead = head;
        
        k = k % len;
        // 移到尾的结点数
        int count = len - k;
        for (int i=0; i<count; i++){
            newHead = head.next;
            head.next = null;
            tail.next = head;
            tail = tail.next;
            head = newHead;
        }
        
        return head;
    }
}