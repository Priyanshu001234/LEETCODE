class Solution {
    public ListNode partition(ListNode head, int x) {

        if (head == null) return null;

        ListNode smallHead = null, smallTail = null;
        ListNode largeHead = null, largeTail = null;

        ListNode temp = head;

        while (temp != null) {

            ListNode nextNode = temp.next;
            temp.next = null;

            if (temp.val < x) {
                if (smallHead == null) {
                    smallHead = temp;
                    smallTail = temp;
                } else {
                    smallTail.next = temp;
                    smallTail = temp;
                }
            } else {
                if (largeHead == null) {
                    largeHead = temp;
                    largeTail = temp;
                } else {
                    largeTail.next = temp;
                    largeTail = temp;
                }
            }

            temp = nextNode;
        }

        if (smallHead == null) return largeHead;

        smallTail.next = largeHead;

        return smallHead;
    }
}
