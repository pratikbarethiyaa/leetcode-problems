class Solution {
    public int minCost(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][][]=new int[m][n][1024];

        dp[0][0][grid[0][0]]=1;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    continue;
                }

                int up[]=new int[1024];
                int left[]=new int[1024];

                if(i>0){
                    up=dp[i-1][j];
                }
                if(j>0){
                    left=dp[i][j-1];
                }

                int combined[]=new int[1024];

                for(int k=0;k<1024;k++){
                    if(up[k]==1 || left[k]==1){
                        combined[k]=1;
                    }
                }

                for(int xorVal=0;xorVal<1024;xorVal++){
                    if(combined[xorVal]==1){
                        int res=xorVal ^ grid[i][j];
                        dp[i][j][res]=1;
                    }
                }
            }
        }
        
        for(int i=0;i<1024;i++){
            if(dp[m-1][n-1][i]==1){
                return i;
            }
        }
        return -1;
        
    }
}