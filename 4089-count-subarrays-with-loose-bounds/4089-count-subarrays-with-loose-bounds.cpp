class Solution {
public:
    typedef long long ll;
    long long countSubarrays(vector<int>& nums, int minK, int maxK) {
        int n=nums.size();
        ll res=0;
        int prev=0;
        for(int i=0;i<n;i++){
            if(nums[i]<minK || nums[i]>maxK){
                int len=i-prev;
                res+=1LL*len*(len+1)/2;
                prev=i+1;
            }
        }
        int len=n-prev;
        res+=1LL*len*(len+1)/2;
        return res;
    }
};