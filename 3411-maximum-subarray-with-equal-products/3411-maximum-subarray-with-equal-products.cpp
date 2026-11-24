class Solution {
public:
    int maxLength(vector<int>& nums) {
        int res=1;
        int n=nums.size();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int prod=1;
                int l=1;
                int g=0;

                for(int k=i;k<=j;k++){
                    prod=(prod*nums[k]);
                    l=lcm(l,nums[k]);
                    g=gcd(g,nums[k]);
                }

                if(prod==l*g){
                    res=max(res,j-i+1);
                }
                if(prod>g*l) break;
            }
        }
        return res;
    }
};