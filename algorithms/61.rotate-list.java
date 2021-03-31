/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
 */

// @lc code=start
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int lenght = 1;
        ListNode cur = head;
        while (cur.next != null) {
            lenght++;
            cur = cur.next;
        }
        ListNode tail = cur;
        k = k % lenght;
        if (k == 0)
            return head;
        int index = lenght - k;
        cur = head;
        while (index > 1) {
            cur = cur.next;
            index--;
        }
        tail.next = head;
        head = cur.next;
        cur.next = null;
        
        return head;
    }
}
// @lc code=end

