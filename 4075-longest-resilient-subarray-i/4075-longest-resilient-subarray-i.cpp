class Solution {
public:
    int resilientSubarray(vector<int>& nums, int k) {
        int n=nums.size();
        int res=0;

        for(int i=0;i<n;i++){
            int sum=0;
            int rem=-1;
            bool valid=true;
            for(int j=i;j<n;j++){
                int currRem=nums[j]%k;
                if(rem==-1){
                    rem=currRem;
                }else if(currRem!=rem){
                    valid=false;
                }
                if(!valid) break;
                
                if(sum%k==0){
                    res=max(res,j-i+1);
                }
                sum+=nums[j];
            }
        }
        return res;
    }
};