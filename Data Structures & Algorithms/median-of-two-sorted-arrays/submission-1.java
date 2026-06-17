class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int odd = (m+n)%2;
        int count = (m+n)/2;
        int i =0, j=0;
        int current = 0, prev = 0;
        int k = 0;
        while(i<m && j<n) {
            if(k>count)
                break;
            if(nums1[i]<nums2[j]) {
                prev = current;
                current = nums1[i];
                i++;
            } else {
                prev = current;
                current = nums2[j];
                j++;
            }
            k++;
        }
        while(i<m) {
            if(k>count)
                break;
            prev = current;
            current = nums1[i];
            i++;
            k++;
        }

        while(j<n) {
            if(k>count)
                break;
            prev = current;
            current = nums2[j];
            j++;
            k++;
        }
        if(odd == 1) {
            return current;
        } else {
            return (double) (prev+current)/2;
        }

    }
}
