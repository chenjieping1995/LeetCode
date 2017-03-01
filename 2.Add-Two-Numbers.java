/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // ��֮ǰ������ӷ�����ͬ, ���⿼����һ��˼·
        // ��l1���ڻ� l2���ڻ� carry!=0ʱ�����Խ���ѭ��, ��ʾ���������Լӵ������ȥ
        //  ����l1, l2. �����ǰ���Ϊ�յĻ�, ��0������˸��ؼ�ֵ, ��l1+l2+carry��ֵ
        //  ����õ�ֵ��10��Ϊcarry, ģ10�Ľ����Ϊ��ǰ���Ĺؼ���
        //  l1,l2 ������next, �����ǰΪnull, ����Ϊnull
        
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode res = new ListNode((l1.val+l2.val)%10);
        ListNode head = res;
        
        int carry = (l1.val + l2.val) / 10;
        
        l1 = l1.next;
        l2 = l2.next;
        
        while ((l1 != null) || (l2 != null) || (carry != 0)) {
            int node = (l1==null ? 0 : l1.val) + (l2==null ? 0 : l2.val) + carry;
            carry = node / 10;
            int remainer = node % 10;
            head.next= new ListNode(remainer);
            head = head.next;
            
            l1 = (l1==null ? null : l1.next);
            l2 = (l2==null ? null : l2.next);
        }
        
        return res;
    }
}