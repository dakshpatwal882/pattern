/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // Approach: Floyd's Cycle Detection (Tortoise and Hare)
        // Use two pointers moving at different speeds.
        // If a cycle exists, the fast pointer will eventually catch the slow one.
        // If there is no cycle, the fast pointer reaches the end (null).

        // FIX: pointers must be ListNode, not int, since they point to nodes
        ListNode slow = head;   // moves 1 step at a time
        ListNode fast = head;   // moves 2 steps at a time

        // Check fast and fast.next to avoid NullPointerException
        // when calling fast.next.next
        while (fast != null && fast.next != null) {
            slow = slow.next;          // move 1 step
            fast = fast.next.next;     // move 2 steps

            // If both pointers meet, a cycle exists
            if (slow == fast) {        // compares references (same node), not values
                return true;
            }
        }

        // Fast reached the end of the list, so there is no cycle
        return false;
    }
}