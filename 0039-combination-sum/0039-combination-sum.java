class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        helper(0, target, temp, candidates, answer);
        return answer;
    }

    public void helper(int index, int target,
                       ArrayList<Integer> list,
                       int[] candidates,
                       List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (index == candidates.length || target < 0) {
            return;
        }

        list.add(candidates[index]);
        helper(index, target - candidates[index], list, candidates, ans);
        list.remove(list.size() - 1); // backtrack

        helper(index + 1, target, list, candidates, ans);
    }
}
