class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int i=0;i<n;i++) {
            set.add(nums[i]);
        }

        Set<Integer> list = new HashSet<>();
        for(int i=0;i<n;i++) {
            if(set.contains(nums[i]-1) == false) {
                list.add(nums[i]);
            }
        }
        int maxLength = 0;
        for(Integer ele:list) {
            int curr = 0;
            Integer currEle = ele;
            while(set.contains(currEle)==true) {
                curr++;
                currEle++;
            }
            if(curr>maxLength)
                maxLength = curr;
        }

        return maxLength;
    }
}
