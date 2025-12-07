//maximum subarray sum in O(n) complexity
//if sum is lesser than 0 then re assign the sum means neglecting the previous part which may be have less sum
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int msum = nums[0];

        for(int i = 1;i<nums.length;i++){
            if(sum < 0)sum = nums[i];
            else sum += nums[i];
            if(sum > msum) msum = sum;
        }
        return msum;
    }
}
