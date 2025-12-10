//sliding window problem asking exactly k subaarsy with ...
// when we have to find exactly k we cant do it single sliding window as we have multiple valid starting points and ending points as we have duplicates and zeros
//so we use sub pattren in sliding window called atmost
//we give k and k - 1 to get the actual answers
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums, k) - atmost(nums, k - 1);
    }
    public int atmost(int[] nums, int k){

        Map<Integer, Integer> map = new HashMap<>();
        int st = 0, res = 0;
        for(int e = 0; e < nums.length; e++){
            map.put(nums[e], map.getOrDefault(nums[e], 0) + 1);

            while(map.size() > k){
                map.put(nums[st], map.get(nums[st]) - 1);
                if(map.get(nums[st]) == 0)map.remove(nums[st]);
                st++;
            }
          //adding all the subarrays where the end of the array is valid to ans res
            res += e - st + 1;
        }
        return res;
    }
}
