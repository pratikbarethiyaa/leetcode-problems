class Solution {
    //finding the max number of copies i can obtain
    public int solve(int i,int budget,int cheapPrice,int items[][],int factor[],int dp[][]){
        if(i==items.length){
            return budget/cheapPrice;
        }
        if(dp[i][budget]!=-1) return dp[i][budget];
        int take=0;
        int notTake=0;
        if(items[i][1]<=budget) take=1+factor[i]+solve(i+1,budget-items[i][1],cheapPrice,items,factor,dp);
        notTake=solve(i+1,budget,cheapPrice,items,factor,dp);
        return dp[i][budget]=Math.max(take,notTake);
    }
    public int maximumSaleItems(int[][] items, int budget) {
        int n=items.length;
        int factor[]=new int[n]; //ill store item as idx with the nums of items it can take
        int cheapPrice=Integer.MAX_VALUE;
        int dp[][]=new int[n+1][1501];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<n;i++){
            cheapPrice=Math.min(cheapPrice,items[i][1]);
            for(int j=0;j<n;j++){
                if(i==j) continue;
                if(items[j][0]%items[i][0]==0){
                    factor[i]+=1;
                }
            }
        }

        return solve(0,budget,cheapPrice,items,factor,dp);
    }
}