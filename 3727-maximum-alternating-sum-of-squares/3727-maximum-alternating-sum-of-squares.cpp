class Solution {
public:
    long long maxAlternatingSum(vector<int>& nums) {
        int n=nums.size();
        for(int i=0;i<n;i++){
            nums[i]=abs(nums[i]);
        }
        sort(nums.begin(),nums.end());
        long long sum=0;
        int r=n%2!=0 ? r=n-2 : n-1;
        int l=0;
        while(l<r){ 
            sum+=(nums[r]*nums[r]-nums[l]*nums[l]);
            l++;
            r--;
        }
        return n%2!=0 ? sum+nums[n-1]*nums[n-1] : sum; 
    }
};