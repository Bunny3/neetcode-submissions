class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int leftProduct[] = new int[n];
        int rightProduct[] = new int[n];
        int result[] = new int[n];
        Arrays.fill(leftProduct, 1);
        Arrays.fill(rightProduct, 1);

        leftProduct[0] = nums[0];
        rightProduct[n-1] = nums[n-1];

        for(int i=1;i<n;i++) {
            leftProduct[i] = nums[i]*leftProduct[i-1];
        }

        for(int i=n-2;i>=0;i--) {
            rightProduct[i] = nums[i]*rightProduct[i+1];
        }
        System.out.println("Left Product");
        for(int i=0;i<n;i++) {
            System.out.print(leftProduct[i]+" , ");
        }
        System.out.println();
        System.out.println("Right Product");
        for(int i=0;i<n;i++) {
            System.out.print(rightProduct[i]+" , ");
        }
        System.out.println();

        for(int i=0;i<n;i++) {
            int left = 1;
            int right = 1;
            if(i>0) {
                left = leftProduct[i-1];
            }

            if(i+1<n) {
                right = rightProduct[i+1];
            }
            result[i] = left * right;
        }
        return result;
    }
}  
