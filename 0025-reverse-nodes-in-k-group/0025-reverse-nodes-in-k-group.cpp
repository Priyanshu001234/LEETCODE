class Solution {
public:
    ListNode* reverseKGroup(ListNode* head, int k) {

        ListNode* curr = head;
        int count = 0;

        while (curr != NULL && count < k) {
            curr = curr->next;
            count++;
        }

        if (count == k) {
            ListNode* currNode = head;
            ListNode* prevNode = NULL;
            ListNode* nextNode = NULL;
            int count2 = 0;

            while (count2 < k) {
                nextNode = currNode->next;
                currNode->next = prevNode;
                prevNode = currNode;
                currNode = nextNode;
                count2++;
            }

            head->next = reverseKGroup(currNode, k);
            return prevNode;
        }

        return head;
    }
};