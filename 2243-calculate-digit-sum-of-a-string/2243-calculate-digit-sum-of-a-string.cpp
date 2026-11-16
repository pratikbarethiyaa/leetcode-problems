class Solution {
public:
    string sum(string s){
        int sumOfDigits=0;
        for(int i=0;i<s.length();i++){
            sumOfDigits+=s[i]-'0';
        }
        return to_string(sumOfDigits);
    }
    string digitSum(string s, int k) {
        string t=s;

        while(t.length()>k){
            string n="";
            for(int i=0;i<t.length();i+=k){
                n+=sum(t.substr(i,k));
            }
            t=n;
        }
        return t;
    }
};