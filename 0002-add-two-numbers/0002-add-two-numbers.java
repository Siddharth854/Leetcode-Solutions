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
        ListNode dummy = new ListNode(0);
        ListNode temp_3 = dummy;
        int carry = 0;
        ListNode temp_1 = l1;
        ListNode temp_2 = l2;
        while(temp_1!=null || temp_2!=null || carry!=0)
        {
            int x = (temp_1!=null)?temp_1.val:0;
            int y = (temp_2!=null)?temp_2.val:0;
            int sum = x+y+carry;
            carry = sum/10;
            temp_3.next = new ListNode(sum%10);
            temp_3 = temp_3.next;
            if(temp_1!=null) 
            {
                temp_1 = temp_1.next;
            }
            if(temp_2!=null)
            {
                temp_2 = temp_2.next;
            }
        }
        return dummy.next;
    }
}