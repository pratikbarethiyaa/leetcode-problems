class Solution {
public:
    int sumCounts(vector<int>& nums) {
        int n=nums.size();
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                unordered_set<int> st;
                for(int k=i;k<=j;k++){
                    if(st.find(nums[k])==st.end()){
                        st.insert(nums[k]);
                    }
                }
                sum+=(st.size()*st.size());
            }
            
        }
        return sum;
    }
};