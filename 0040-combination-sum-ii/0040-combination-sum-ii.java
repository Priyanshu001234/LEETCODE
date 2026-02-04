class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(candidates); 
        helper(0, target, new ArrayList<>(), candidates, answer, candidates.length);
        return answer;
    }

    public void helper(int index, int target,
                       ArrayList<Integer> list,
                       int[] candidates,
                       List<List<Integer>> ans,
                       int n) {

        // ✅ base case
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (index == n || target < 0) {
            return;
        }

        // 🔁 loop instead of direct pick/skip
        for (int i = index; i < n; i++) {

            // 🔑 skip duplicates
            if (i > index && candidates[i] == candidates[i - 1])
                continue;

            if (candidates[i] > target)
                break;

            // pick (only once → i+1)
            list.add(candidates[i]);
            helper(i + 1, target - candidates[i], list, candidates, ans, n);
            list.remove(list.size() - 1); // backtrack
        }
    }
}
