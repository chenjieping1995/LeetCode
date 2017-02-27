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
        // ����һ��ָ������ߵ�ͷ,����������ĳ���
        // len - k ���ɵõ���Ҫ�Ƶ�β���Ľ�����
        // ��ָ������ƶ���㵽β��
        
        ListNode tail = head;
        
        if ((head == null) || (head.next == null))   return head;
        
        // ������
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len ++;
        }
        
        ListNode newHead = head;
        
        k = k % len;
        // �Ƶ�β�Ľ����
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