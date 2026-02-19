import java.util.*;

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;

        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);

        int start = 0;
        int end = list.size() - 1;

        while (start < end) {
            int sum = list.get(start) + list.get(end);

            if (sum < k) {
                start++;
            } else if (sum > k) {
                end--;
            } else {
                return true;
            }
        }

        return false;   
    }

    private void inOrder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}
