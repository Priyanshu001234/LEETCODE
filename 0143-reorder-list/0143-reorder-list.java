class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // 1️⃣ Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2️⃣ Push second half into stack
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = slow.next;
        slow.next = null; // split list

        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        // 3️⃣ Reorder using stack
        curr = head;
        while (!stack.isEmpty()) {
            ListNode temp = curr.next;
            ListNode top = stack.pop();

            curr.next = top;
            top.next = temp;

            curr = temp;
        }
    }
}
