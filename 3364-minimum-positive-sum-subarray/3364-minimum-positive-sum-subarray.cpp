class Solution {
public:
    int minimumSumSubarray(vector<int>& nums, int l, int r) {
        int res=INT_MAX;

        for(int i=0;i<nums.size();i++){
            int sum=0;
            int currLen=1;
            for(int j=i;j<nums.size();j++){
                sum+=nums[j];
                if(currLen>=l && currLen<=r){
                    if(sum>0) res=min(res,sum);
                }
                currLen++;
            }
        }
        return res==INT_MAX ? -1 : res;
    }
};