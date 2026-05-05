class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // Edge cases: empty list, single node, or no rotation
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // 1. Compute the length and find the actual tail
        ListNode tail = head;
        int length = 1; 
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // 2. Handle cases where k >= length
        k = k % length;
        if (k == 0) return head;

        // 3. Connect tail to head to make it circular
        tail.next = head;

        // 4. Find the new tail: it is (length - k) nodes from the start
        // To get to the (length - k)-th node, we take (length - k - 1) steps
        ListNode newTail = head;
        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }

        // 5. Establish the new head and break the circular link
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}