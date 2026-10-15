class Solution {
public:
    string maxSumOfSquares(int num, int sum) {
        if(sum>9*num) return "";
        string res(num,'0');

        for(int i=0;i<num;i++){
            int dig=min(9,sum);
            res[i]=dig+'0';
            sum-=dig;
            if(sum<0) break;
        }

        return res;

    }
};