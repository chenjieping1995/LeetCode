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
        // 与之前做的相加方法不同, 本题考虑另一种思路
        // 当l1存在或 l2存在或 carry!=0时都可以进入循环, 表示还有数可以加到结果中去
        //  对于l1, l2. 如果当前结点为空的话, 以0来代替此个关键值, 求l1+l2+carry的值
        //  将求得的值除10作为carry, 模10的结果作为当前结点的关键字
        //  l1,l2 等于其next, 如果当前为null, 则仍为null
        
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