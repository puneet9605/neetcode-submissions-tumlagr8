/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next !=null  && fast.next.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null;
        while(curr!=null){
            ListNode tempNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNext;
        }
        ListNode frwd = head;
        while (prev!=null){
            ListNode tempfrwdNext = frwd.next;
            ListNode tempbkwdNext = prev.next;
            frwd.next = prev;
            prev.next = tempfrwdNext;
            frwd = tempfrwdNext;
            prev = tempbkwdNext;
        }    
    }
}
