class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        
        if(costBoth<= cost1 && costBoth<=cost2){
            return Math.max(need1,need2)*1L*costBoth;
        }else if(costBoth>cost1 && costBoth>cost2){
            long res1=(long)Math.min(need1,need2)*costBoth;
            if(need1>need2){
                res1+=(long)(need1-need2)*cost1;
            }else{
                res1+=(long)(need2-need1)*cost2;
            }
            long res2=(long)cost1*need1+(long)cost2*need2;
            return Math.min(res1,res2);
        }else{ //1 3 2 3 2
            long res1=0L;
            if(cost1<=costBoth){
                res1+=(long)need2*costBoth;
                if(need1>need2){
                    res1+=(long)(need1-need2)*cost1;
                    
                }
            }else{
                res1+=(long)need1*costBoth;
                if(need2>need1){
                    res1+=(long)(need2-need1)*cost2;
                }
            }
            long res2=(long)cost1*need1+(long)cost2*need2;
            return Math.min(res1,res2);
        }
    }
}
