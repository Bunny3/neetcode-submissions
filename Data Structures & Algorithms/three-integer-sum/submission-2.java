class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        int copyArr[] = Arrays.copyOf(nums, n);
        Arrays.sort(copyArr);
       
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int i=0;i<n;i++) {
            if (copyArr[i] > 0) break;
            if(i>0 && copyArr[i]==copyArr[i-1]) continue;
            int target = -copyArr[i];
            int j=i+1, k=n-1;
            while(j<k) {
                int sum = copyArr[j]+copyArr[k];
                if(sum == target) {
                    List<Integer> triplet = new ArrayList<>(List.of(copyArr[i],copyArr[k],copyArr[j]));
                    j++;
                    k--;
                    while (j < k && copyArr[j] == copyArr[j - 1]) j++; // skip duplicate j
                    while (j < k && copyArr[k] == copyArr[k + 1]) k--;
                    ans.add(triplet);
                } else if(sum >target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return ans;
    }
}
