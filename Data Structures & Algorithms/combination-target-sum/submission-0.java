class Solution {
    public void dfs(int[] nums, int i, int target, List<Integer> subset, List<List<Integer>> res) {
        if(target == 0) {
            res.add(new ArrayList<>(subset));
            return;
        }
        if(target<0 || i>=nums.length) {
            return;
        }
        subset.add(nums[i]);
        // dfs(nums, i+1, target-nums[i], subset, res);
        dfs(nums, i, target-nums[i], subset, res);
        subset.remove(subset.size()-1);
        dfs(nums, i+1, target, subset, res);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        int i =0;
        dfs(nums, i, target, subset, res);
        return res;
    }
}
