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

        // Your approach: push ALL nodes into min heap
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );

        for (ListNode node : lists) {
            ListNode temp = node;
            while (temp != null) {
                pq.offer(temp);
                temp = temp.next;
            }
        }

        // If heap is empty → all lists were empty
        if (pq.isEmpty()) return null;

        ListNode smallest = pq.poll();
        ListNode head = new ListNode(smallest.val);
        ListNode temp = head;

        while (!pq.isEmpty()) {
            ListNode node = new ListNode(pq.poll().val);
            temp.next = node;
            temp = temp.next;
        }

        return head;
    }
}