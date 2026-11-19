class Solution {
    public int minimizeSum(int[] nums) {
        //8 28 42 58 75
        Arrays.sort(nums);
        int res=Math.min(nums[nums.length-2]-nums[1],Math.min(nums[nums.length-1]-nums[2],nums[nums.length-3]-nums[0]));
        
        return res;

    }
}