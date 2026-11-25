class Solution {
    static class Pair implements Comparable<Pair>{
        int node;
        int cost;
        Pair(int n,int c){
            this.node=n;
            this.cost=c;
        }

        @Override
        public int compareTo(Pair p2){
            return this.cost-p2.cost;
        }
    }
    public int minimumObstacles(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean vis[][]=new boolean[m][n];
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        int dirs[][]={{0,1},{1,0},{0,-1},{-1,0}};

        pq.add(new Pair(0,0));
        vis[0][0]=true;
        while(!pq.isEmpty()){
            int size=pq.size();
                Pair curr=pq.remove();
                int currCell=curr.node;
                int row=currCell/n;
                int col=currCell%n;
                if(row==m-1 && col==n-1){
                    return curr.cost;
                }
                for(int dir[]:dirs){
                    int r=row+dir[0];
                    int c=col+dir[1];
                    if(r>=0 && c>=0 && r<m && c<n && (!vis[r][c])){
                        vis[r][c]=true;
                        if(grid[r][c]==1){
                            pq.add(new Pair(r*n+c,curr.cost+1));
                        }
                        if(grid[r][c]==0){
                            pq.add(new Pair(r*n+c,curr.cost));
                        }
                    }
                }            
        }
        return -1;
    }
}