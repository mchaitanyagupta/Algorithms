
//if we have n/2 +1 elements we can do ans++ when element and ans-- when its not there fore we end being in that element as it has more count than all combined
// every ans at zero change the ans to current element to update the ans
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int ans = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(count ==0){
                ans = nums[i];
            }
            if(nums[i] == ans)count++;
            else count--;
        }
        return ans;
        
    }
}
