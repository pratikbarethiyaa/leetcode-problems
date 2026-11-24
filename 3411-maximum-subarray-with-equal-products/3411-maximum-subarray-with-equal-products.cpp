class Solution {
public:
    int maxLength(vector<int>& nums) {
        int res=1;
        int n=nums.size();
        int mod=1e9+7;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                long long prod=1;
                int l=1;
                int g=0;

                for(int k=i;k<=j;k++){
                    prod=(prod*nums[k])%mod;
                    l=lcm(l,nums[k]);
                    g=gcd(g,nums[k]);
                }

                if(prod==l*g){
                    res=max(res,j-i+1);
                }
            }
        }
        return res;
    }
};