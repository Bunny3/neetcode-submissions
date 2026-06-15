class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l=0, r=n-1;
        while(l<=r) {
            int mid = l + (r-l)/2;
            if(nums[mid]==target)
                return mid;
            // Left half sorted
            if (nums[l] <= nums[mid]) {
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid-1;
                } else {
                    l = mid+1;
                }
            }
            // Right half sorted
            else {
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid+1;
                } else {
                    r = mid-1;
                }
            }
        }
        // System.out.println(nums[l]);
        // System.out.println(nums[r]);
        // if(nums[l] == target)
        //     return l;
        // else if(nums[r] == target)
        //     return r;
        // else 
           return -1;
    }
}
