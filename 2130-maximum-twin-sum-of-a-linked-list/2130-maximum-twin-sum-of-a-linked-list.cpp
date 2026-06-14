/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    int pairSum(ListNode* head) {

        ListNode * slow = head;
        ListNode * fast = head;

        while(fast!=nullptr){
            slow = slow->next;
            fast = fast->next->next;
        }

        //Now reverse the linked list (second half)
        ListNode * prev = nullptr;
        ListNode *curr = slow;
      
        
        while(curr!=nullptr){
            ListNode *next = curr->next;
            curr->next = prev;
            prev = curr;
            curr = next;
        }

        ListNode * ptr = head;

        int ans = INT_MIN;
        ListNode * tempHead = prev;

        while(tempHead!=nullptr){

            int res = ptr->val + tempHead->val;
            ans = max(ans,res);
            ptr = ptr->next;
            tempHead = tempHead->next;

        }

        return ans;



        
    }
};