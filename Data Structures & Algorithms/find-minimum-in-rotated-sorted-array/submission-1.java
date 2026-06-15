class Solution {
    public int findMin(int[] nums) {
     int L=0, R= nums.length-1;
     int n = nums.length;
    //  if(nums.length == 2) {
    //     return (int)Math.min(nums[0],nums[1]);
    //  }
     while(L+1<R) {
        int mid = L + (R-L)/2;
        if(nums[mid]<nums[mid-1]) 
            return nums[mid];
        else if(nums[mid]>nums[n-1]) {
            L = mid;
        } else {
            R = mid;
        }
     }
     return (int)Math.min(nums[R],nums[L]);
    }
}
