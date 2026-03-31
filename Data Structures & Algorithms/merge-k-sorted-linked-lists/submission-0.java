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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        for(int i =0 ; i<lists.length-1; i++){
            ListNode head1 = lists[i];
            ListNode head2 = lists[i+1];
            ListNode dummy = new ListNode();
            ListNode curr = dummy;
            while(head1!=null && head2!=null){
                if(head1.val<head2.val){
                    curr.next = head1;
                    head1 = head1.next;
                } else {
                    curr.next = head2;
                    head2 = head2.next;
                }
                curr = curr.next;

            }
            if(head1!=null){
                curr.next = head1;
            }
            if(head2!=null){
                curr.next = head2;
            }
            lists[i+1] = dummy.next;

        }
        return lists[lists.length-1];
    }
}
