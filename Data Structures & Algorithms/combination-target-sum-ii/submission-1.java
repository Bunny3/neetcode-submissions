class Solution {
    public void dfs(int[] candidates, int i, int target, List<Integer> subset,List<List<Integer>> res) {

        if(target == 0) {
            res.add(new ArrayList<>(subset));
            return;
        }
        if(target<0 || i>=candidates.length) {
            return;
        }
        subset.add(candidates[i]);
        dfs(candidates, i+1, target-candidates[i], subset, res);
        subset.remove(subset.size()-1);
        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }
        dfs(candidates, i+1, target, subset, res);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, subset, res);
        return res;
    }
}
