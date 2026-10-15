class Solution {
public:
    string maxSumOfSquares(int num, int sum) {
        string res;
        int i=0;
        while(sum>0){
            int dig=(sum<9 ? sum : 9);
            res.push_back(dig+'0');
            if(res.length()>num) return "";
            sum-=dig;
            i++;
            
        }
        while(i<num){
            res.push_back('0');
            i++;
        }
        return res;

    }
};