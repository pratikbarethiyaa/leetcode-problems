class Solution {
public:
    int longestMonotonicSubarray(vector<int>& nums) {
        int res=0;
        int n=nums.size();
        if(n==1) return 1;
        for(int i=1;i<n;i++){
            int s=1;
            while(i<n && nums[i-1]<nums[i]){
                s++;
                i++;
            }
            res=max(res,s);
        }
        for(int i=1;i<n;i++){
            int s=1;
            while(i<n && nums[i-1]>nums[i]){
                s++;
                i++;
            }
            res=max(res,s);
        }

        return res;
    }
};