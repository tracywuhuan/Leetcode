//https://leetcode.com/problems/palindrome-linked-list/description/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();
        ListNode p = head;
        while(p!=null){
            stack.push(p.val);
            p=p.next;
        }
        while(head!=null){
            if(stack.pop()!=head.val){
                return false;
            }
            head=head.next;
        }
        return true;
    }
}
