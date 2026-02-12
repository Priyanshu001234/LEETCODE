class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if (head == null) return null;

        ListNode sizeNode = head;
        int size = 1;

        while (sizeNode.next != null) {
            size++;
            sizeNode = sizeNode.next;
        }

        if (n == size) {
            return head.next;
        }

        int steps = size - n;
        ListNode temp = head;

        for (int i = 1; i < steps; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }
}
