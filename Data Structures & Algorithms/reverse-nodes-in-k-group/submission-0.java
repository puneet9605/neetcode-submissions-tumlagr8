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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        ListNode reversePointer = dummy;
        ListNode curr = head;
        while(curr!=null){
            ListNode check = curr;
            int count = 0;
            while (count < k && check != null) {
                check = check.next;
                count++;
            }
            if (count < k) {            
                reversePointer.next = curr;
                break;
            }
            int j = 0;
            ListNode prev = null;
            ListNode groupHead = curr;  
            while (j<k && curr!=null){
                ListNode currNext = curr.next;
                curr.next = prev;
                prev = curr;
                curr = currNext;
                j++;
            }
            reversePointer.next = prev;
            reversePointer = groupHead; 

        }
        return dummy.next;
        
    }
}
