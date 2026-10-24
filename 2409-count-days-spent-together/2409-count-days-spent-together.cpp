class Solution {
public:
    int toDay(string date, vector<int>& preSum) {
        int month = stoi(date.substr(0, 2));
        int day = stoi(date.substr(3));

        return (month == 1 ? 0 : preSum[month - 2]) + day;
    }
    int countDaysTogether(string arriveAlice, string leaveAlice, string arriveBob, string leaveBob) {
        vector<int> days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        vector<int> preSum(12);
        preSum[0]=days[0];
        for(int i=1;i<12;i++){
            preSum[i]=preSum[i-1]+days[i];
        }

        int aliceArrive = toDay(arriveAlice, preSum);
        int aliceLeft   = toDay(leaveAlice, preSum);
        int bobArrive   = toDay(arriveBob, preSum);
        int bobLeft     = toDay(leaveBob, preSum);

        if(aliceLeft<bobArrive || bobLeft<aliceArrive) return 0;

        int start=max(aliceArrive,bobArrive);
        int end=min(aliceLeft,bobLeft);
        return end-start+1;
    
    }
};