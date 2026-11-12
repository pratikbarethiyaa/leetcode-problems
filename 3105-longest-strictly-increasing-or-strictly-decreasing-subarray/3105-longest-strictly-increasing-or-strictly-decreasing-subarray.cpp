class Solution {
public:
    int longestMonotonicSubarray(vector<int>& nums) {
        int res=1;
        int n=nums.size();
        if(n==1) return 1;
        int s=1;
        int d=1;
        for(int i=1;i<n;i++){
            s=(nums[i-1]<nums[i]) ? s+=1 : 1;
            d=(nums[i-1]>nums[i]) ? d+=1 : 1;
            res=max({res,s,d});
        }

        return res;
    }
};