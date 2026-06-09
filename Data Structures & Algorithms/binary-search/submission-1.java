class Solution {
    public int search(int[] nums, int target) {
        int l=-1, r= nums.length;
        while(l+1<r) {
            int mid = l + (r-l)/2;
            if(nums[mid]<=target)
            {
                l = mid;
            } else {
                r = mid;
            }
        }
        if(l==-1)
            return l;
        return nums[l]==target?l:-1;
    }
}
