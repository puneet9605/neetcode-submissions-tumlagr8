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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode sumHead = new ListNode();
        ListNode temp = sumHead;
        while(l1!=null && l2!=null){
            int sum = l1.val + l2.val +carry;
            carry = sum/10;
            sum = sum%10;
            temp.next = new ListNode(sum);
            l1 = l1.next;
            l2 = l2.next;
            temp = temp.next;
        }
        while (l1!=null){
            int sum = l1.val+carry;
            carry = sum/10;
            sum = sum%10;
            temp.next = new ListNode(sum);
            l1 = l1.next;
            temp = temp.next;
        }
        while (l2!=null){
            int sum = l2.val+carry;
            carry = sum/10;
            sum = sum%10;
            temp.next = new ListNode(sum);
            l2 = l2.next;
            temp = temp.next;
        }
        if (carry!=0){
            temp.next = new ListNode(carry);
        }
        return sumHead.next;

    }
}